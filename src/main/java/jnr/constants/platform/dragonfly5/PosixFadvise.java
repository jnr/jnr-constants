// WARNING: This file is autogenerated. DO NOT EDIT!
// Generated 2019-09-24 00:13:52 +0000
package jnr.constants.platform.dragonfly5;
public enum PosixFadvise implements jnr.constants.Constant {
POSIX_FADV_NORMAL(0L),
POSIX_FADV_SEQUENTIAL(1L),
POSIX_FADV_RANDOM(2L),
POSIX_FADV_NOREUSE(5L),
POSIX_FADV_WILLNEED(3L),
POSIX_FADV_DONTNEED(4L);
private final long value;
private PosixFadvise(long value) { this.value = value; }
public static final long MIN_VALUE = 0L;
public static final long MAX_VALUE = 5L;

static final class StringTable {
  public static final java.util.Map<PosixFadvise, String> descriptions = generateTable();
  public static final java.util.Map<PosixFadvise, String> generateTable() {
    java.util.Map<PosixFadvise, String> map = new java.util.EnumMap<PosixFadvise, String>(PosixFadvise.class);
  map.put(POSIX_FADV_NORMAL, "POSIX_FADV_NORMAL");
  map.put(POSIX_FADV_SEQUENTIAL, "POSIX_FADV_SEQUENTIAL");
  map.put(POSIX_FADV_RANDOM, "POSIX_FADV_RANDOM");
  map.put(POSIX_FADV_NOREUSE, "POSIX_FADV_NOREUSE");
  map.put(POSIX_FADV_WILLNEED, "POSIX_FADV_WILLNEED");
  map.put(POSIX_FADV_DONTNEED, "POSIX_FADV_DONTNEED");
    return map;
  }
}
public final String toString() { return StringTable.descriptions.get(this); }
public final int value() { return (int) value; }
public final int intValue() { return (int) value; }
public final long longValue() { return value; }
public final boolean defined() { return true; }
}
