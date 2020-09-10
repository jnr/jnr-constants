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

package jnr.constants;

import jnr.constants.platform.Errno;

import java.io.InputStream;
import java.lang.reflect.Field;
import java.net.URL;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Provides forward and reverse lookup for platform constants
 */
public class ConstantSet extends AbstractSet<Constant> {
    private final Map<String, Constant> nameToConstant;
    private final Map<Long, Constant> valueToConstant;
    private final Set<Enum> constants;
    private final Class<Enum> enumClass;
    private volatile Long minValue;
    private volatile Long maxValue;
    
    private static final ConcurrentMap<String, ConstantSet> constantSets
            = new ConcurrentHashMap<String, ConstantSet>();
    private static final Object lock = new Object();
    private static final ClassLoader LOADER;
    private static final boolean CAN_LOAD_RESOURCES;
    private static volatile Throwable RESOURCE_READ_ERROR;

    static {
        ClassLoader _loader = ConstantSet.class.getClassLoader();
        if (_loader != null) {
            LOADER = _loader;
        } else {
            LOADER = ClassLoader.getSystemClassLoader();
        }

        boolean canLoadResources = false;
        try {
            URL thisClass = AccessController.doPrivileged(new PrivilegedAction<URL>() {
                public URL run() {
                    return LOADER.getResource("jnr/constants/ConstantSet.class");
                }
            });

            InputStream stream = thisClass.openStream();

            try {
                stream.read();
            } catch (Throwable t) {
                // save for future reporting, can't read the stream for whatever reason
                RESOURCE_READ_ERROR = t;
            } finally {
                try {
                    stream.close();
                } catch (Exception e) {
                    // ignore
                }
            }

            canLoadResources = true;
        } catch (Throwable t) {
            if (RESOURCE_READ_ERROR == null) {
                RESOURCE_READ_ERROR = t;
            }
        }

        CAN_LOAD_RESOURCES = canLoadResources;
    }

    /**
     * Gets a <code>ConstantSet</code>
     *
     * @param name The name of the constant set to get.
     * @return A <code>ConstantSet</code>.
     */
    public static ConstantSet getConstantSet(String name) {
        ConstantSet constants = constantSets.get(name);
        return constants != null ? constants : loadConstantSet(name);
    }

    private static ConstantSet loadConstantSet(String name) {
        synchronized (lock) {
            ConstantSet constants = constantSets.get(name);
            if (constants == null) {
                Class<Enum> enumClass = getEnumClass(name);
                if (enumClass == null) {
                    return null;
                }
                if (!Constant.class.isAssignableFrom(enumClass)) {
                    throw new ClassCastException("class for " + name
                            + " does not implement Constant interface");
                }

                constantSets.put(name, constants = new ConstantSet(enumClass));
            }

            return constants;
        }
    }

    /**
     * Gets the {@link Enum} class for the constant name space.
     *
     * @param name The name of the constants to locate.
     * @return A Class.
     */
    @SuppressWarnings("unchecked")
    private static final Class<Enum> getEnumClass(String name) {
        String[] prefixes = PlatformConstants.getPlatform().getPackagePrefixes();

        for (String prefix : prefixes) {
            String fullName = prefix + "." + name;
            boolean doClass = true;

            if (CAN_LOAD_RESOURCES) {
                // Reduce exceptions on boot by trying to find the class as a resource first
                String path = fullName.replace('.', '/') + ".class";
                URL resource = LOADER.getResource(path);

                // Able to load resources, but couldn't find this, bail out
                if (resource == null) doClass = false;
            }

            if (doClass) {
                try {
                    return (Class<Enum>) Class.forName(fullName, true, LOADER).asSubclass(Enum.class);
                } catch (ClassNotFoundException ex) {
                }
            }
        }
        return null;
    }

    /**
     * Creates a new instance of <code>ConstantSet</code>
     *
     * @param enumClass The Enum subclass to load constants from.
     */
    @SuppressWarnings("unchecked")
    private ConstantSet(Class<Enum> enumClass) {
        this.enumClass = enumClass;
        this.constants = EnumSet.allOf(enumClass);

        Map<String, Constant> names = new HashMap<String, Constant>();
        Map<Long, Constant> values = new HashMap<Long, Constant>();
        for (Enum e : constants) {
            if (e instanceof Constant) {
                Constant c = (Constant) e;
                names.put(e.name(), c);
                values.put(c.longValue(), c);
            }
        }

        nameToConstant = Collections.unmodifiableMap(names);
        valueToConstant = Collections.unmodifiableMap(values);
    }

    /**
     * Gets the constant for a name.
     *
     * @param name The name of the system constant (e.g. "EINVAL").
     * @return A {@link Constant} instance.
     */
    public final Constant getConstant(String name) {
        return nameToConstant.get(name);
    }

    /**
     * Gets the constant for a value.
     *
     * @param value A system constant value.
     * @return A {@link Constant} instance.
     */
    public Constant getConstant(long value) {
        return valueToConstant.get(value);
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
            Field f = enumClass.getField(name);
            return (Long) f.get(enumClass);
        } catch (NoSuchFieldException ex) {
            return defaultValue;
        } catch (RuntimeException ex) {
            throw ex;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    /**
     * Returns the minimum value in this ConstantSet
     * @return a long value
     */
    public long minValue() {
        if (minValue == null) {
            minValue = getLongField("MIN_VALUE", Integer.MIN_VALUE);
        }
        return minValue.intValue();
    }

    /**
     * Returns the maximum value in this ConstantSet
     * @return a long value
     */
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

    public static void main(String[] args) {
        System.out.println(Errno.values().length);
    }
}
