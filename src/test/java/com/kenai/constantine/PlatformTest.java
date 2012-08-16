package com.kenai.constantine;

import junit.framework.Assert;

import org.junit.Test;

public class PlatformTest {

    @Test
    public void testPlatformPackageName() {
        Assert.assertEquals("Package name for platform class is hard-coded but no longer matches",
            Platform.getConstantsPackageName(), Platform.class.getPackage().getName());
    }
}
