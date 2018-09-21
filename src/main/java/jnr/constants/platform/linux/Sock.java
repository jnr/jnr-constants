// WARNING: This file is autogenerated. DO NOT EDIT!
// Generated 2018-09-21 14:38:46 +0200
package jnr.constants.platform.linux;
public enum Sock implements jnr.constants.Constant {
SOCK_STREAM(1L),
SOCK_DGRAM(2L),
SOCK_RAW(3L),
SOCK_RDM(4L),
SOCK_SEQPACKET(5L),
// SOCK_MAXADDRLEN not defined
SOCK_CLOEXEC(524288L);
private final long value;
private Sock(long value) { this.value = value; }
public static final long MIN_VALUE = 1L;
public static final long MAX_VALUE = 524288L;

static final class StringTable {
  public static final java.util.Map<Sock, String> descriptions = generateTable();
  public static final java.util.Map<Sock, String> generateTable() {
    java.util.Map<Sock, String> map = new java.util.EnumMap<Sock, String>(Sock.class);
  map.put(SOCK_STREAM, "SOCK_STREAM");
  map.put(SOCK_DGRAM, "SOCK_DGRAM");
  map.put(SOCK_RAW, "SOCK_RAW");
  map.put(SOCK_RDM, "SOCK_RDM");
  map.put(SOCK_SEQPACKET, "SOCK_SEQPACKET");
  map.put(SOCK_CLOEXEC, "SOCK_CLOEXEC");
    return map;
  }
}
public final String toString() { return StringTable.descriptions.get(this); }
public final int value() { return (int) value; }
public final int intValue() { return (int) value; }
public final long longValue() { return value; }
public final boolean defined() { return true; }
}
