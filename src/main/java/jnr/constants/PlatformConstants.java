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

import java.nio.ByteOrder;
import java.util.HashMap;
import java.util.Map;

/**
 * Platform specific constants.
 */
public final class PlatformConstants {
    private static final PlatformConstants INSTANCE = new PlatformConstants();

    public static PlatformConstants getPlatform() {
        return INSTANCE;
    }

    private static final class PackageNameResolver {
        public static final String PACKAGE_NAME = new PackageNameResolver().inferPackageName();

        private String inferPackageName() {
            try {
                Class cls = getClass();
                Package pkg = cls.getPackage();
                return pkg != null ? pkg.getName(): cls.getName().substring(0, cls.getName().lastIndexOf('.'));
            } catch (NullPointerException npe) {
                return "jnr.constants";
            }
        }
    }

    private PlatformConstants() { }

    private static String getConstantsPackageName() {
        return PackageNameResolver.PACKAGE_NAME;
    }

    public static final boolean FAKE = Boolean.valueOf(System.getProperty("jnr.constants.fake", "true"));

    public String[] getPackagePrefixes() {
        if (FAKE) {
            return new String[] {
                    getArchPackageName(),
                    getOSPackageName(),
                    getFakePackageName(),
            };
        } else {
            return new String[] {
                    getArchPackageName(),
                    getOSPackageName(),
            };
        }
    }

    public String getArchPackageName() {
        return String.format("%s.platform.%s.%s", getConstantsPackageName(), OS, ARCH);
    }

    public String getOSPackageName() {
        return String.format("%s.platform.%s", getConstantsPackageName(), OS);
    }

    public String getFakePackageName() {
        return String.format("%s.platform.fake", getConstantsPackageName());
    }

    public static final Map<String, String> OS_NAMES = new HashMap<String, String>() {{
            put("Mac OS X", "darwin");
            put("SunOS", "solaris");
        }
        public static final long serialVersionUID = 1L;
    };

    public static final Map<String, String> ARCH_NAMES = new HashMap<String, String>() {{
            put("x86", "i386");
        }
        public static final long serialVersionUID = 1L;
    };

    private static String initOperatingSystem() {
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
