// WARNING: This file is autogenerated. DO NOT EDIT!
// Generated 2020-09-03 02:05:33 +0200
package jnr.constants.platform.windows;
public enum INet6 implements jnr.constants.Constant {
INET6_ADDRSTRLEN(65L);
private final long value;
private INet6(long value) { this.value = value; }
public static final long MIN_VALUE = 65L;
public static final long MAX_VALUE = 65L;

static final class StringTable {
  public static final java.util.Map<INet6, String> descriptions = generateTable();
  public static final java.util.Map<INet6, String> generateTable() {
    java.util.Map<INet6, String> map = new java.util.EnumMap<INet6, String>(INet6.class);
  map.put(INET6_ADDRSTRLEN, "INET6_ADDRSTRLEN");
    return map;
  }
}
public final String toString() { return StringTable.descriptions.get(this); }
public final int value() { return (int) value; }
public final int intValue() { return (int) value; }
public final long longValue() { return value; }
public final boolean defined() { return true; }
}