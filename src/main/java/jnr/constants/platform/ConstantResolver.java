/*
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package jnr.constants.platform;

import jnr.constants.platform.*;
import jnr.constants.Constant;
import jnr.constants.ConstantSet;
import java.lang.reflect.Array;
import java.util.EnumSet;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Provides forward and reverse lookup utilities to cross-platform enums
 */
class ConstantResolver<E extends Enum<E>> {
    public static final String __UNKNOWN_CONSTANT__ = "__UNKNOWN_CONSTANT__";
    private final Object modLock = new Object();
    private final Class<E> enumType;
    private final Map<Long, E> reverseLookupMap = new ConcurrentHashMap<Long, E>();
    private final AtomicLong nextUnknown;;
    private final boolean bitmask;

    private Constant[] cache = null;
    private volatile E[] valueCache = null;
    private volatile int cacheGuard = 0;
    private volatile ConstantSet constants;

    private ConstantResolver(Class<E> enumType) {
        this(enumType, Integer.MIN_VALUE, Integer.MIN_VALUE + 1000, false);
    }

    private ConstantResolver(Class<E> enumType, int firstUnknown, int lastUnknown, boolean bitmask) {
        this.enumType = enumType;
        this.nextUnknown = new AtomicLong(firstUnknown);
        this.bitmask = bitmask;
    }
    
    static <T extends Enum<T>> ConstantResolver<T> getResolver(Class<T> enumType) {
        return new ConstantResolver<T>(enumType);
    }

    static <T extends Enum<T>> ConstantResolver<T> getResolver(Class<T> enumType, int first, int last) {
        return new ConstantResolver<T>(enumType, first, last, false);
    }

    static <T extends Enum<T>> ConstantResolver<T> getBitmaskResolver(Class<T> enumType) {
        return new ConstantResolver<T>(enumType, 0, 0x80000000, true);
    }

    private static final class UnknownConstant implements Constant {
        private final long value;
        private final String name;
        UnknownConstant(long value, String name) {
            this.value = value;
            this.name = name;
        }

        public int value() {
            return (int) value;
        }

        public final int intValue() {
            return (int) value;
        }

        public final long longValue() {
            return value;
        }

        public final String name() {
            return name;
        }

        public final boolean defined() {
            return false;
        }

        @Override
        public final String toString() {
            return name;
        }
    }

    
    private Constant getConstant(E e) {
        Constant c;
        if (cacheGuard != 0 && (c = cache[e.ordinal()]) != null) { // read volatile guard
            return c;
        }
        // fallthru to slow lookup+add
        return lookupAndCacheConstant(e);
    }

    private Constant lookupAndCacheConstant(E e) {
        synchronized (modLock) {
            Constant c;

            // Recheck, in case another thread loaded the table
            if (cacheGuard != 0 && (c = cache[e.ordinal()]) != null) {
                return c;
            }
            EnumSet<E> enums = EnumSet.allOf(enumType);
            ConstantSet cset = getConstants();
            if (cache == null) {
                cache = new Constant[enums.size()];
            }
            
            long known = 0, unknown = 0;
            for (Enum v : enums) {
                c = cset.getConstant(v.name());
                if (c == null) {
                    if (bitmask) {
                        // Flag the value as unknown - real values will be
                        // inserted once all values are resolved, so there are
                        // no collisions
                        unknown |= (1L << v.ordinal());
                        c = new UnknownConstant(0, v.name());
                    } else {
                        c = new UnknownConstant(nextUnknown.getAndAdd(1), v.name());
                    }
                } else if (bitmask) {
                    known |= c.longValue();
                }
                cache[v.ordinal()] = c;
            }

            //
            // For bitmask constant sets, we generate bitmask values for missing
            // constants by utilising unused bits
            //
            if (bitmask) {
                long mask = 0;
                while ((mask = Long.lowestOneBit(unknown)) != 0) {
                    int index = Long.numberOfTrailingZeros(mask);
                    int sparebit = Long.numberOfTrailingZeros(Long.lowestOneBit(~known));
                    int value = 1 << sparebit;
                    cache[index] = new UnknownConstant(value, cache[index].name());
                    known |= value;
                    unknown &= ~(1L << index);
                }
            }
            cacheGuard = 1; // write volatile guard
            return cache[e.ordinal()];
        }

    }

    final int intValue(E e) {
        return getConstant(e).intValue();
    }


    final long longValue(E e) {
        return getConstant(e).longValue();
    }


    final String description(E e) {
         return getConstant(e).toString();
    }


    final boolean defined(E e) {
        return getConstant(e).defined();
    }


    @SuppressWarnings("unchecked")
    final E valueOf(long value) {
        E e;
        if (value >= 0 && value < 256 && valueCache != null && (e = valueCache[(int) value]) != null) {
            return e;
        }
        e = reverseLookupMap.get(value);
        if (e != null) {
            return e;
        }
        
        Constant c = getConstants().getConstant(value);
        if (c != null) {
            try {
                e = Enum.valueOf(enumType, c.name());
                reverseLookupMap.put(value, e);
                if (c.intValue() >= 0 && c.intValue() < 256) {
                    E[] values = valueCache;
                    if (values == null) {
                        values = (E[]) Array.newInstance(enumType, 256);
                    }
                    values[c.intValue()] = e;
                    valueCache = values;
                }
                return e;
            } catch (IllegalArgumentException ex) {}
        }
        return Enum.valueOf(enumType, __UNKNOWN_CONSTANT__);
    }

    private ConstantSet getConstants() {
        if (constants == null) {
            constants = ConstantSet.getConstantSet(enumType.getSimpleName());
            if (constants == null) {
                throw new RuntimeException("Could not load platform constants for " + enumType.getSimpleName());
            }
        }
        return constants;
    }
}
