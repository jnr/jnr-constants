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
import jnr.constants.ConstantSet;
import java.util.EnumSet;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 */
public class ErrnoTest {
    private ConstantSet constants;
    public ErrnoTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
        constants = ConstantSet.getConstantSet("Errno");
    }

    @After
    public void tearDown() {
    }

    @Test public void intValue() {
        for (Errno errno : EnumSet.allOf(Errno.class)) {
            if (errno == Errno.__UNKNOWN_CONSTANT__ || !errno.defined()) {
                continue;
            }
            long val = constants.getValue(errno.name());
            assertEquals("Incorrect integer value for " + errno.name() + ",", val, errno.longValue());
        }
    }
    @Test public void valueOf() {
        for (Errno errno : EnumSet.allOf(Errno.class)) {
            if (errno == Errno.__UNKNOWN_CONSTANT__ || !errno.defined()) {
                continue;
            }
            Errno e = Errno.valueOf(errno.longValue());
            assertEquals("Incorrect integer value for " + errno.name() + ",", errno.longValue(), e.longValue());
        }
    }
    @Test public void description() {
        for (Errno errno : Errno.values()) {
            if (errno == Errno.__UNKNOWN_CONSTANT__ || !errno.defined()) {
                continue;
            }
            assertNotSame("Lack of description for " + errno.name(), errno.name(), errno.toString());
        }
    }
    @Test public void expected() {
        for (Errno e : new Errno[] {Errno.ENOENT, Errno.EINVAL, Errno.EISDIR}) {
            assertNotSame(e.name() + " is unknown", Errno.__UNKNOWN_CONSTANT__, e);
        }
    }
    @Test public void unknownConstant() {
        Errno none = Errno.valueOf(~0);
        assertEquals("Incorrect errno for unknown value", Errno.__UNKNOWN_CONSTANT__, none);
    }
    @Test public void reverseLookupCache() {
        for (Errno errno : EnumSet.allOf(Errno.class)) {
            if (errno == Errno.__UNKNOWN_CONSTANT__ || !errno.defined()) {
                continue;
            }
            Errno e1 = Errno.valueOf(errno.longValue());
            Errno e2 = Errno.valueOf(errno.longValue());

            assertEquals("Cached Enum values differ for " + errno.name() + ",", e1, e2);
        }
    }
}