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

import jnr.constants.platform.*;
import junit.framework.Assert;
import org.junit.Test;

/**
 * Created by headius on 5/24/14.
 */
public class DefinedTest {
    @Test
    public void testDefined() throws Throwable {
        // At least one constant should be undefined on any given platform, right?
        boolean allDefined = true;
        for (Constant[] constants : new Constant[][]{
                AddressFamily.values(),
                Errno.values(),
                Fcntl.values(),
                INAddr.values(),
                IPProto.values(),
                NameInfo.values(),
                OpenFlags.values(),
                PRIO.values(),
                ProtocolFamily.values(),
                RLIM.values(),
                Shutdown.values(),
                Signal.values(),
                Sock.values(),
                SocketLevel.values(),
                SocketOption.values(),
                Sysconf.values(),
                Pathconf.values(),
                Confstr.values(),
                TCP.values(),
                WaitFlags.values()
        }) for (Constant constant : AddressFamily.values()) {
            allDefined = allDefined & constant.defined();
        }
        Assert.assertFalse("no constants were undefined", allDefined);
    }

    @Test
    public void testLangInfoUnix() throws Throwable {
        if (!Platform.OS.equals("windows")) {
            Assert.assertTrue(LangInfo.CODESET.defined());
        }
    }

    @Test
    public void testUndefinedConstant() throws Throwable {
        if (Platform.OS.equals("linux")) {
            Assert.assertFalse(AddressFamily.AF_CHAOS.defined());
            if (Platform.FAKE) {
                Assert.assertTrue(AddressFamily.AF_CHAOS.intValue() >= 20000);

            } else {
                try {
                    AddressFamily.AF_CHAOS.intValue();
                    Assert.fail();
                } catch (AssertionError e) {
                    Assert.assertTrue(true);
                }
            }
        }
    }
}
