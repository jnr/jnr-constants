// WARNING: This file is autogenerated. DO NOT EDIT!
// Generated 2021-10-08 17:37:30 +0200
package jnr.constants.platform.freebsd;
public enum Multicast implements jnr.constants.Constant {
MCAST_JOIN_GROUP(80L),
MCAST_BLOCK_SOURCE(84L),
MCAST_UNBLOCK_SOURCE(85L),
MCAST_LEAVE_GROUP(81L),
MCAST_JOIN_SOURCE_GROUP(82L),
MCAST_LEAVE_SOURCE_GROUP(83L),
// MCAST_MSFILTER not defined
MCAST_EXCLUDE(2L),
MCAST_INCLUDE(1L);
private final long value;
private Multicast(long value) { this.value = value; }
public static final long MIN_VALUE = 1L;
public static final long MAX_VALUE = 85L;

static final class StringTable {
  public static final java.util.Map<Multicast, String> descriptions = generateTable();
  public static final java.util.Map<Multicast, String> generateTable() {
    java.util.Map<Multicast, String> map = new java.util.EnumMap<Multicast, String>(Multicast.class);
  map.put(MCAST_JOIN_GROUP, "MCAST_JOIN_GROUP");
  map.put(MCAST_BLOCK_SOURCE, "MCAST_BLOCK_SOURCE");
  map.put(MCAST_UNBLOCK_SOURCE, "MCAST_UNBLOCK_SOURCE");
  map.put(MCAST_LEAVE_GROUP, "MCAST_LEAVE_GROUP");
  map.put(MCAST_JOIN_SOURCE_GROUP, "MCAST_JOIN_SOURCE_GROUP");
  map.put(MCAST_LEAVE_SOURCE_GROUP, "MCAST_LEAVE_SOURCE_GROUP");
  map.put(MCAST_EXCLUDE, "MCAST_EXCLUDE");
  map.put(MCAST_INCLUDE, "MCAST_INCLUDE");
    return map;
  }
}
public final String toString() { return StringTable.descriptions.get(this); }
public final int value() { return (int) value; }
public final int intValue() { return (int) value; }
public final long longValue() { return value; }
public final boolean defined() { return true; }
}
