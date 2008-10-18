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

package com.kenai.constantine.platform;

import com.kenai.constantine.Constant;
import com.kenai.constantine.ConstantSet;
import java.util.EnumSet;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Provides forward and reverse lookup utilities to cross-platform enums
 */
class ConstantResolver<E extends Enum<E>> {
    public static final String __UNKNOWN_CONSTANT__ = "__UNKNOWN_CONSTANT__";
    private final Object modLock = new Object();
    private final Class<E> enumType;
    private final Map<Integer, E> reverseLookupMap = new ConcurrentHashMap<Integer, E>();

    private Integer[] values = null;
    private volatile ConstantSet constants;
    private volatile int valuesGuard = 0;

    private ConstantResolver(Class<E> enumType) {
        this.enumType = enumType;
    }
    static final <T extends Enum<T>> ConstantResolver<T> getResolver(Class<T> enumType) {
        return new ConstantResolver<T>(enumType);
    }
    final int intValue(E e) {
        if (valuesGuard != 0) { // read volatile guard
            Integer i = values[e.ordinal()];
            if (i != null) {
                return i;
            }
            // fallthru to slow lookup+add
        }
        Integer i;
        synchronized (modLock) {
            Constant c = getConstants().getConstant(e.name());
            if (c == null) {
                throw new RuntimeException("No platform value for " + e.name());
            }
            if (values == null) {
                values = new Integer[EnumSet.allOf(enumType).size()];
            }
            values[e.ordinal()] = (i = c.value());
            valuesGuard = valuesGuard + 1; // write volatile guard
        }
        return i;
    }
    final E valueOf(int value) {
        E e = reverseLookupMap.get(value);
        if (e != null) {
            return e;
        }
        for (Constant c : getConstants()) {
            if (c.value() == value) {
                try {
                    reverseLookupMap.put(value, e = Enum.valueOf(enumType, c.name()));
                    return e;
                } catch (IllegalArgumentException ex) {}
            }
        }
        return Enum.valueOf(enumType, __UNKNOWN_CONSTANT__);
    }
    private final ConstantSet getConstants() {
        if (constants == null) {
            constants = ConstantSet.getConstantSet(enumType.getSimpleName());
            if (constants == null) {
                throw new RuntimeException("Could not load platform constants for " + enumType.getSimpleName());
            }
        }
        return constants;
    }
}
