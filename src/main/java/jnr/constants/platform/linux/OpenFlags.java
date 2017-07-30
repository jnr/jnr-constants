// WARNING: This file is autogenerated. DO NOT EDIT!
// Generated 2017-07-30 01:16:55 +0000
package jnr.constants.platform.linux;
public enum OpenFlags implements jnr.constants.Constant {
O_RDONLY(0L),
O_WRONLY(1L),
O_RDWR(2L),
O_ACCMODE(3L),
O_NONBLOCK(2048L),
O_APPEND(1024L),
O_SYNC(1052672L),
// O_SHLOCK not defined
// O_EXLOCK not defined
O_ASYNC(8192L),
O_FSYNC(1052672L),
O_NOFOLLOW(131072L),
O_CREAT(64L),
O_TRUNC(512L),
O_EXCL(128L),
// O_EVTONLY not defined
O_DIRECTORY(65536L),
// O_SYMLINK not defined
// O_BINARY not defined
O_NOCTTY(256L),
// O_TMPFILE not defined
O_CLOEXEC(524288L);
private final long value;
private OpenFlags(long value) { this.value = value; }
public static final long MIN_VALUE = 0L;
public static final long MAX_VALUE = 1052672L;

public final int intValue() { return (int) value; }
public final long longValue() { return value; }
public final boolean defined() { return true; }
}
