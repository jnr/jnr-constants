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

import java.nio.ByteOrder;
import java.util.HashMap;
import java.util.Map;

/**
 * Platform specific constants.
 */
public class Platform {
    private static final Platform INSTANCE = new Platform();
    public static Platform getPlatform() {
        return INSTANCE;
    }
    protected Platform() {
    }

    static String getConstantsPackageName() {
        // Determining this dynamically fails if jarjar is used, so hardcode instead
        // Update this if you change the package name or refactor this class
        return "com.kenai.constantine";
    }

    public String getPackageName() {
        return String.format("%s.platform.%s.%s", getConstantsPackageName(), OS, ARCH);
    }
    public String getOSPackageName() {
        return String.format("%s.platform.%s", getConstantsPackageName(), OS);
    }

    public static final Map<String, String> OS_NAMES = new HashMap<String, String>() {{
            put("Mac OS X", "darwin");
        }
        public static final long serialVersionUID = 1L;
    };
    public static final Map<String, String> ARCH_NAMES = new HashMap<String, String>() {{
            put("x86", "i386");
        }
        public static final long serialVersionUID = 1L;
    };
    private static final String initOperatingSystem() {
        String osname = getProperty("os.name", "unknown").toLowerCase();
        for (String s : OS_NAMES.keySet()) {
            if (s.equalsIgnoreCase(osname)) {
                return OS_NAMES.get(s);
            }
        }
        if (osname.startsWith("windows")) {
            return "windows";
        }
        return osname;
    }
    private static final String initArchitecture() {
        String arch = getProperty("os.arch", "unknown").toLowerCase();
        for (String s : ARCH_NAMES.keySet()) {
            if (s.equalsIgnoreCase(arch)) {
                return ARCH_NAMES.get(s);
            }
        }
        return arch;
    }
    public static final String ARCH = initArchitecture();
    public static final String OS = initOperatingSystem();
    public static final String NAME = String.format("%s-%s", ARCH, OS);

    public static final int BIG_ENDIAN = 4321;
    public static final int LITTLE_ENDIAN = 1234;
    public static final int BYTE_ORDER = ByteOrder.nativeOrder().equals(ByteOrder.BIG_ENDIAN) ? BIG_ENDIAN : LITTLE_ENDIAN;

    private static String getProperty(String property, String defValue) {
        try {
            return System.getProperty(property, defValue);
        } catch (SecurityException se) {
            return defValue;
        }
    }
}
