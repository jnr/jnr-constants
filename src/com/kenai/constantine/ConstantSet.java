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

package com.kenai.constantine;

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
    private final ConcurrentMap<Integer, Constant> valueToConstant;
    private final Set<Constant> constants;
    private final Class<Enum> enumClass;

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
                if (!constantSets.containsKey(name)) {
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
        String[] prefixes = {
            Platform.getPlatform().getPackageName(),
            Platform.getPlatform().getOSPackageName(),
            Platform.class.getPackage().getName() + ".platform.fake",
        };
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
        valueToConstant = new ConcurrentHashMap<Integer, Constant>();
        constants = (Set<Constant>) EnumSet.allOf(enumClass);
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
     * @param name The name of the system constant (e.g. "EINVAL").
     * @return A {@link Constant} instance.
     */
    @SuppressWarnings("unchecked")
    public Constant getConstant(int value) {
        Constant c = valueToConstant.get(value);
        if (c == null) {
            if (c == null) {
                for (Constant c2 : constants) {
                    if (c2.value() == value) {
                        c = c2;
                        break;
                    }
                }
                if (c != null) {
                    valueToConstant.put(value, c);
                }
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
    public int getValue(String name) {
        Constant c = getConstant(name);
        return c != null ? c.value() : 0;
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

    private final class ConstantIterator implements Iterator<Constant> {
        private final Iterator<Constant> it;
        
        ConstantIterator(Collection<Constant> constants) {
            this.it = constants.iterator();
        }
        public boolean hasNext() {
            return it.hasNext();
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public Constant next() {
            return it.next();
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

    public static void main(String[] args) {
        ConstantSet errnos = ConstantSet.getConstantSet("Errno");
        for (Constant c : errnos) {
            System.out.println(c.name() + "=" + c.value());
        }
        com.kenai.constantine.platform.Errno errno = com.kenai.constantine.platform.Errno.valueOf(22);
        System.out.println("errno for 22=" + errno);
        System.out.println("errno for 101=" + com.kenai.constantine.platform.Errno.valueOf(101));
        System.out.println("errno for 22=" + com.kenai.constantine.platform.Errno.valueOf(22));
        System.out.println("EINVAL.value() = " + com.kenai.constantine.platform.Errno.EINVAL.value());
        System.out.println("E2BIG.value() = " + com.kenai.constantine.platform.Errno.E2BIG.value());
    }
}
