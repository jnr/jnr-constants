// WARNING: This file is autogenerated. DO NOT EDIT!
// Generated 2018-09-08 09:14:58 +0200
package jnr.constants.platform.linux;
public enum PosixFadvise implements jnr.constants.Constant {
POSIX_FADV_NORMAL(0L),
POSIX_FADV_SEQUENTIAL(2L),
POSIX_FADV_RANDOM(1L),
POSIX_FADV_NOREUSE(5L),
POSIX_FADV_WILLNEED(3L),
POSIX_FADV_DONTNEED(4L);
private final long value;
private PosixFadvise(long value) { this.value = value; }
public static final long MIN_VALUE = 0L;
public static final long MAX_VALUE = 5L;

public final int intValue() { return (int) value; }
public final long longValue() { return value; }
public final boolean defined() { return true; }
}
