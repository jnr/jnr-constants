// WARNING: This file is autogenerated. DO NOT EDIT!
// Generated 2021-06-03 11:07:36 +0800
package jnr.constants.platform.linux.loongarch64;
public enum Access implements jnr.constants.Constant {
F_OK(0L),
X_OK(1L),
W_OK(2L),
R_OK(4L);
private final long value;
private Access(long value) { this.value = value; }
public static final long MIN_VALUE = 0L;
public static final long MAX_VALUE = 4L;

static final class StringTable {
  public static final java.util.Map<Access, String> descriptions = generateTable();
  public static final java.util.Map<Access, String> generateTable() {
    java.util.Map<Access, String> map = new java.util.EnumMap<Access, String>(Access.class);
  map.put(F_OK, "F_OK");
  map.put(X_OK, "X_OK");
  map.put(W_OK, "W_OK");
  map.put(R_OK, "R_OK");
    return map;
  }
}
public final String toString() { return StringTable.descriptions.get(this); }
public final int value() { return (int) value; }
public final int intValue() { return (int) value; }
public final long longValue() { return value; }
public final boolean defined() { return true; }
}
