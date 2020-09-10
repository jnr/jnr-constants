/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package jnr.constants.platform;

import jnr.constants.PlatformConstants;
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
            checkFake();
            return (int) value;
        }

        public final int intValue() {
            checkFake();
            return (int) value;
        }

        public final long longValue() {
            checkFake();
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

        private void checkFake() {
            if (!PlatformConstants.FAKE) {
                throw new AssertionError("Constant " + name + " is not defined on " + PlatformConstants.NAME);
            }
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
