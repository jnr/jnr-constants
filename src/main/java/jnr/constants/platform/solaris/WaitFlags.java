// WARNING: This file is autogenerated. DO NOT EDIT!
// Generated 2018-09-09 19:50:17 +0200
package jnr.constants.platform.solaris;
public enum WaitFlags implements jnr.constants.Constant {
WNOHANG(0x40L),
WUNTRACED(0x4L),
WSTOPPED(0x4L),
WEXITED(0x1L),
WCONTINUED(0x8L),
WNOWAIT(0x80L);
private final long value;
private WaitFlags(long value) { this.value = value; }
public static final long MIN_VALUE = 0x1L;
public static final long MAX_VALUE = 0x80L;

public final int intValue() { return (int) value; }
public final long longValue() { return value; }
public final boolean defined() { return true; }
}
