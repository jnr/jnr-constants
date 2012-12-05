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

package jnr.constants;

import java.lang.reflect.Field;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Provides forward and reverse lookup for platform constants
 */
public class ConstantSet extends AbstractSet<Constant> {
    private final ConcurrentMap<String, Constant> nameToConstant;
    private final ConcurrentMap<Long, Constant> valueToConstant;
    private final Set<Enum> constants;
    private final Class<Enum> enumClass;
    private volatile Long minValue;
    private volatile Long maxValue;
    
    private static final ConcurrentMap<String, ConstantSet> constantSets
            = new ConcurrentHashMap<String, ConstantSet>();
    private static final Object lock = new Object();

    /**
     * Gets a <tt>ConstantSet</tt>
     *
     * @param name The name of the constant set to get.
     * @return A <tt>ConstantSet</tt>.
     */
    public static ConstantSet getConstantSet(String name) {
        ConstantSet constants = constantSets.get(name);
        if (constants == null) {
            synchronized (lock) {
                constants = constantSets.get(name);
                if (constants == null) {
                    Class<Enum> enumClass = getEnumClass(name);
                    if (enumClass == null) {
                        return null;
                    }
                    if (!Constant.class.isAssignableFrom(enumClass)) {
                        throw new ClassCastException("class for " + name
                                + " does not implement Constant interface");
                    }
                    constants = new ConstantSet(enumClass);
                    constantSets.put(name, constants);
                }
            }
        }
        return constants;
    }

    /**
     * Gets the {@link Enum} class for the constant name space.
     *
     * @param name The name of the constants to locate.
     * @return A Class.
     */
    @SuppressWarnings("unchecked")
    private static final Class<Enum> getEnumClass(String name) {
        String[] prefixes = Platform.getPlatform().getPackagePrefixes();

        for (String prefix : prefixes) {
            try {
                return (Class<Enum>) Class.forName(prefix + "." + name).asSubclass(Enum.class);
            } catch (ClassNotFoundException ex) {
            }
        }
        return null;
    }

    /**
     * Creates a new instance of <tt>ConstantSet</tt>
     *
     * @param enumClass The Enum subclass to load constants from.
     */
    @SuppressWarnings("unchecked")
    private ConstantSet(Class<Enum> enumClass) {
        this.enumClass = enumClass;
        nameToConstant = new ConcurrentHashMap<String, Constant>();
        valueToConstant = new ConcurrentHashMap<Long, Constant>();
        constants = EnumSet.allOf(enumClass);
    }

    /**
     * Gets the constant for a name.
     *
     * @param name The name of the system constant (e.g. "EINVAL").
     * @return A {@link Constant} instance.
     */
    @SuppressWarnings("unchecked")
    public Constant getConstant(String name) {
        Constant c = nameToConstant.get(name);
        if (c == null) {
            try {
                nameToConstant.put(name, c = Constant.class.cast(Enum.valueOf(enumClass, name)));
            } catch (IllegalArgumentException ex) {
                return null;
            }
        }
        return c;
    }

    /**
     * Gets the constant for a name.
     *
     * @param value A system constant value.
     * @return A {@link Constant} instance.
     */
    @SuppressWarnings("unchecked")
    public Constant getConstant(long value) {
        Constant c = valueToConstant.get(value);
        if (c == null) {
            for (Enum e : constants) {
                if (e instanceof Constant && ((Constant) e).longValue() == value) {
                    c = (Constant) e;
                    break;
                }
            }
            if (c != null) {
                valueToConstant.put(value, c);
            }
        }
        return c;
    }

    /**
     * Gets the integer value of a platform constant.
     *
     * @param name The name of the platform constant to look up (e.g. "EINVAL").
     * @return The integer value of the constant.
     */
    public long getValue(String name) {
        Constant c = getConstant(name);
        return c != null ? c.longValue() : 0;
    }

    /**
     * Gets the name of a platform constant value.
     *
     * @param value The integer value to look up.
     * @return The name of the constant.
     */
    public String getName(int value) {
        Constant c = getConstant(value);
        return c != null ? c.name() : "unknown";
    }
    private Long getLongField(String name, long defaultValue) {
        try {
            Field f = enumClass.getField("MIN_VALUE");
            return (Long) f.get(enumClass);
        } catch (NoSuchFieldException ex) {
            return defaultValue;
        } catch (RuntimeException ex) {
            throw ex;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
    public long minValue() {
        if (minValue == null) {
            minValue = getLongField("MIN_VALUE", Integer.MIN_VALUE);
        }
        return minValue.intValue();
    }
    public long maxValue() {
        if (maxValue == null) {
            maxValue = getLongField("MAX_VALUE", Integer.MAX_VALUE);
        }
        return maxValue.intValue();
    }

    private final class ConstantIterator implements Iterator<Constant> {
        private final Iterator<Enum> it;
        private Constant next = null;
        
        ConstantIterator(Collection<Enum> constants) {
            this.it = constants.iterator();
            next = it.hasNext() ? (Constant) it.next() : null;
        }

        public boolean hasNext() {
            return next != null && !next.name().equals("__UNKNOWN_CONSTANT__");
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public Constant next() {
            Constant prev = next;
            next = it.hasNext() ? (Constant) it.next() : null;
            return prev;
        }
        
    }
    @Override
    public Iterator<Constant> iterator() {
        return new ConstantIterator(constants);
    }

    @Override
    public int size() {
        return constants.size();
    }

    @Override
    public boolean contains(Object o) {
        return o != null && o.getClass().equals(enumClass);
    }
}
