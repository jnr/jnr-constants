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
                TCP.values(),
                WaitFlags.values()
        }) for (Constant constant : AddressFamily.values()) {
            allDefined = allDefined & constant.defined();
        }
        Assert.assertFalse("no constants were undefined", allDefined);
    }
}
