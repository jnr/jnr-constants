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

package com.kenai.constantine;

import java.lang.reflect.Field;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Provides forward and reverse lookup for platform constants
 */
@Deprecated
public class ConstantSet extends AbstractSet<Constant> {
    private final ConcurrentMap<String, Constant> nameToConstant;
    private final ConcurrentMap<Integer, Constant> valueToConstant;
    private final jnr.constants.ConstantSet constants;

    private static final ConcurrentMap<String, ConstantSet> constantSets = new ConcurrentHashMap<String, ConstantSet>();
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
                    constants = new ConstantSet(jnr.constants.ConstantSet.getConstantSet(name));
                    constantSets.put(name, constants);
                }
            }
        }
        return constants;
    }


    /**
     * Creates a new instance of <tt>ConstantSet</tt>
     *
     * @param constants The JNR constants to lookup real values in
     */
    @SuppressWarnings("unchecked")
    private ConstantSet(jnr.constants.ConstantSet constants) {
        nameToConstant = new ConcurrentHashMap<String, Constant>();
        valueToConstant = new ConcurrentHashMap<Integer, Constant>();
        this.constants = constants;
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
            synchronized (lock) {
                if (!nameToConstant.containsKey(name)) {
                    jnr.constants.Constant jnrConstant = constants.getConstant(name);
                    if (jnrConstant != null) {
                        nameToConstant.put(name, c = new ConstantImpl(jnrConstant));
                        valueToConstant.put(jnrConstant.intValue(), c);
                    }
                }
            }
        }
        return c;
    }

    /**
     * Gets the constant for a name.
     *
     * @param value The name of the system constant (e.g. "EINVAL").
     * @return A {@link Constant} instance.
     */
    @SuppressWarnings("unchecked")
    public Constant getConstant(int value) {
        Constant c = valueToConstant.get(value);
        return c != null ? c : getConstant(constants.getConstant(value).name());
    }

    /**
     * Gets the integer value of a platform constant.
     *
     * @param name The name of the platform constant to look up (e.g. "EINVAL").
     * @return The integer value of the constant.
     */
    public int getValue(String name) {
        return (int) constants.getValue(name);
    }

    /**
     * Gets the name of a platform constant value.
     *
     * @param value The integer value to look up.
     * @return The name of the constant.
     */
    public String getName(int value) {
        return constants.getName(value);
    }

    public long minValue() {
        return constants.minValue();
    }

    public long maxValue() {
        return constants.maxValue();
    }

    private final class ConstantImpl implements Constant {
        private final jnr.constants.Constant constant;

        ConstantImpl(jnr.constants.Constant constant) {
            this.constant = constant;
        }

        public int value() {
            return constant.intValue();
        }

        public int intValue() {
            return constant.intValue();
        }

        public long longValue() {
            return constant.longValue();
        }

        public String name() {
            return constant.name();
        }

        public boolean defined() {
            return true;
        }

        public int hashCode() {
            return constant.hashCode();
        }

        public boolean equals(Object other) {
            return other instanceof ConstantImpl && ((ConstantImpl) other).constant.equals(constant);
        }

        public final String toString() {
            return constant.toString();
        }
    }

    private final class ConstantIterator implements Iterator<Constant> {
        private final Iterator<jnr.constants.Constant> it;
        
        ConstantIterator() {
            this.it = constants.iterator();
        }

        public boolean hasNext() {
            return it.hasNext();
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public Constant next() {
            return getConstant(it.next().name());
        }
        
    }
    @Override
    public Iterator<Constant> iterator() {
        return new ConstantIterator();
    }

    @Override
    public int size() {
        return constants.size();
    }

    @Override
    public boolean contains(Object o) {
        return o != null && o.getClass().equals(ConstantImpl.class) && nameToConstant.values().contains(o);
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
