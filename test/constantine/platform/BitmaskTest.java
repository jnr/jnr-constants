
package constantine.platform;

import com.kenai.constantine.platform.OpenFlags;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class BitmaskTest {

    public BitmaskTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test public void openflags() {
        int mask = 0;
        for (OpenFlags f : OpenFlags.values()) {
            if (f != OpenFlags.O_ACCMODE && f != OpenFlags.O_FSYNC) {
                assertFalse("OpenFlag " + f.name() + " already found",
                        (mask & f.value()) != 0);
            }
            mask |= f.value();
        }
    }

}