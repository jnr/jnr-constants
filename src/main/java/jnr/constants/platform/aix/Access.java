// This file was filled out by hand, because the generator didn't spit it out
// for some reason.  All the values are identical to the Linux one.

package jnr.constants.platform.aix;

public enum Access implements jnr.constants.Constant {
F_OK(0L),
X_OK(1L),
W_OK(2L),
R_OK(4L);
private final long value;
private Access(long value) { this.value = value; }
public static final long MIN_VALUE = 0L;
public static final long MAX_VALUE = 4L;

public final int intValue() { return (int) value; }
public final long longValue() { return value; }
public final boolean defined() { return true; }
}
