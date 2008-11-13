/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package constantine.platform;

import com.kenai.constantine.platform.Errno;
import com.kenai.constantine.ConstantSet;
import java.util.EnumSet;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author wayne
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

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test public void intValue() {
        for (Errno errno : EnumSet.allOf(Errno.class)) {
            if (errno == Errno.__UNKNOWN_CONSTANT__) {
                continue;
            }
            int val = constants.getValue(errno.name());
            assertEquals("Incorrect integer value for " + errno.name() + ",", val, errno.value());
        }
    }
    @Test public void valueOf() {
        for (Errno errno : EnumSet.allOf(Errno.class)) {
            if (errno == Errno.__UNKNOWN_CONSTANT__) {
                continue;
            }
            Errno e = Errno.valueOf(errno.value());
            assertEquals("Incorrect integer value for " + errno.name() + ",", errno.value(), e.value());
        }
    }
    @Test public void description() {
        for (Errno errno : Errno.values()) {
            if (errno == Errno.__UNKNOWN_CONSTANT__) {
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
            if (errno == Errno.__UNKNOWN_CONSTANT__) {
                continue;
            }
            Errno e1 = Errno.valueOf(errno.value());
            Errno e2 = Errno.valueOf(errno.value());

            assertEquals("Cached Enum values differ for " + errno.name() + ",", e1, e2);
        }
    }
}