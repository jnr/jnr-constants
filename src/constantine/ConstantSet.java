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

package constantine;

import constantine.Constant;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Provides forward and reverse lookup for platform constants
 */
public class ConstantSet {
    private final ConcurrentMap<String, Constant> nameToConstant;
    private final ConcurrentMap<Integer, Constant> valueToConstant;
    private final Collection<Constant> constants;
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
    public static ConstantSet getConstants(String name) {
        ConstantSet constants = constantSets.get(name);
        if (constants == null) {
            synchronized (lock) {
                if (!constantSets.containsKey(name)) {
                    constants = new ConstantSet(name);
                    constantSets.put(name, constants);
                }
            }
        }
        return constants;
    }
    /**
     * Creates a new instance of <tt>ConstantSet</tt>
     *
     * @param name The name of the constants to load (e.g. Errno, Socket)
     */
    @SuppressWarnings("unchecked")
    private ConstantSet(String name) {
        nameToConstant = new ConcurrentHashMap<String, Constant>();
        valueToConstant = new ConcurrentHashMap<Integer, Constant>();
        String[] prefixes = {
            Platform.getPlatform().getPackageName(),
            Platform.getPlatform().getOSPackageName(),
        };
        Class constClass = null;

        for (String prefix : prefixes) {
            try {
                constClass = Class.forName(prefix + "." + name);
            } catch (ClassNotFoundException ex) {
            }
        }
        enumClass = constClass.asSubclass(Enum.class);
        constants = Collections.unmodifiableSet((Set<Constant>) EnumSet.allOf(enumClass));
    }

    /**
     * Returns a collection of all the constants for this set.
     *
     * @return A Collection.
     */
    public Collection<Constant> getAll() {
        return constants;
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
            c = Constant.class.cast(Enum.valueOf(enumClass, name));
            if (c == null) {
                return null;
            }
            nameToConstant.put(name, c);
        }
        return c;
    }

    /**
     * Gets the integer value of a platform constant.
     *
     * @param name The name of the platform constant to look up (e.g. "EINVAL").
     * @return The integer value of the constant.
     */
    @SuppressWarnings("unchecked")
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
        Constant c = valueToConstant.get(value);
        if (c == null) {
            for (Constant c2 : constants) {
                if (c2.value() == value) {
                    c = c2;
                    break;
                }
            }
            if (c == null) {
                return "unknown";
            }
            valueToConstant.put(value, c);
        }
        return c.name();
    }
}
