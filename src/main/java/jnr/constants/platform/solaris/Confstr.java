// WARNING: This file is autogenerated. DO NOT EDIT!
// Generated 2020-08-29 20:54:32 +0200
package jnr.constants.platform.solaris;
public enum Confstr implements jnr.constants.Constant {
_CS_PATH(65L),
_CS_POSIX_V7_ILP32_OFF32_CFLAGS(900L),
_CS_POSIX_V7_ILP32_OFF32_LDFLAGS(901L),
_CS_POSIX_V7_ILP32_OFF32_LIBS(902L),
_CS_POSIX_V7_ILP32_OFFBIG_CFLAGS(904L),
_CS_POSIX_V7_ILP32_OFFBIG_LDFLAGS(905L),
_CS_POSIX_V7_ILP32_OFFBIG_LIBS(906L),
_CS_POSIX_V7_LP64_OFF64_CFLAGS(908L),
_CS_POSIX_V7_LP64_OFF64_LDFLAGS(909L),
_CS_POSIX_V7_LP64_OFF64_LIBS(910L),
_CS_POSIX_V7_LPBIG_OFFBIG_CFLAGS(912L),
_CS_POSIX_V7_LPBIG_OFFBIG_LDFLAGS(913L),
_CS_POSIX_V7_LPBIG_OFFBIG_LIBS(914L),
_CS_POSIX_V7_WIDTH_RESTRICTED_ENVS(918L),
_CS_V7_ENV(919L),
_CS_POSIX_V6_ILP32_OFF32_CFLAGS(800L),
_CS_POSIX_V6_ILP32_OFF32_LDFLAGS(801L),
_CS_POSIX_V6_ILP32_OFF32_LIBS(802L),
_CS_POSIX_V6_ILP32_OFFBIG_CFLAGS(804L),
_CS_POSIX_V6_ILP32_OFFBIG_LDFLAGS(805L),
_CS_POSIX_V6_ILP32_OFFBIG_LIBS(806L),
_CS_POSIX_V6_LP64_OFF64_CFLAGS(808L),
_CS_POSIX_V6_LP64_OFF64_LDFLAGS(809L),
_CS_POSIX_V6_LP64_OFF64_LIBS(810L),
_CS_POSIX_V6_LPBIG_OFFBIG_CFLAGS(812L),
_CS_POSIX_V6_LPBIG_OFFBIG_LDFLAGS(813L),
_CS_POSIX_V6_LPBIG_OFFBIG_LIBS(814L),
_CS_POSIX_V6_WIDTH_RESTRICTED_ENVS(816L),
_CS_V6_ENV(817L);
// _CS_GNU_LIBC_VERSION not defined
// _CS_GNU_LIBPTHREAD_VERSION not defined
private final long value;
private Confstr(long value) { this.value = value; }
public static final long MIN_VALUE = 65L;
public static final long MAX_VALUE = 919L;

static final class StringTable {
  public static final java.util.Map<Confstr, String> descriptions = generateTable();
  public static final java.util.Map<Confstr, String> generateTable() {
    java.util.Map<Confstr, String> map = new java.util.EnumMap<Confstr, String>(Confstr.class);
  map.put(_CS_PATH, "_CS_PATH");
  map.put(_CS_POSIX_V7_ILP32_OFF32_CFLAGS, "_CS_POSIX_V7_ILP32_OFF32_CFLAGS");
  map.put(_CS_POSIX_V7_ILP32_OFF32_LDFLAGS, "_CS_POSIX_V7_ILP32_OFF32_LDFLAGS");
  map.put(_CS_POSIX_V7_ILP32_OFF32_LIBS, "_CS_POSIX_V7_ILP32_OFF32_LIBS");
  map.put(_CS_POSIX_V7_ILP32_OFFBIG_CFLAGS, "_CS_POSIX_V7_ILP32_OFFBIG_CFLAGS");
  map.put(_CS_POSIX_V7_ILP32_OFFBIG_LDFLAGS, "_CS_POSIX_V7_ILP32_OFFBIG_LDFLAGS");
  map.put(_CS_POSIX_V7_ILP32_OFFBIG_LIBS, "_CS_POSIX_V7_ILP32_OFFBIG_LIBS");
  map.put(_CS_POSIX_V7_LP64_OFF64_CFLAGS, "_CS_POSIX_V7_LP64_OFF64_CFLAGS");
  map.put(_CS_POSIX_V7_LP64_OFF64_LDFLAGS, "_CS_POSIX_V7_LP64_OFF64_LDFLAGS");
  map.put(_CS_POSIX_V7_LP64_OFF64_LIBS, "_CS_POSIX_V7_LP64_OFF64_LIBS");
  map.put(_CS_POSIX_V7_LPBIG_OFFBIG_CFLAGS, "_CS_POSIX_V7_LPBIG_OFFBIG_CFLAGS");
  map.put(_CS_POSIX_V7_LPBIG_OFFBIG_LDFLAGS, "_CS_POSIX_V7_LPBIG_OFFBIG_LDFLAGS");
  map.put(_CS_POSIX_V7_LPBIG_OFFBIG_LIBS, "_CS_POSIX_V7_LPBIG_OFFBIG_LIBS");
  map.put(_CS_POSIX_V7_WIDTH_RESTRICTED_ENVS, "_CS_POSIX_V7_WIDTH_RESTRICTED_ENVS");
  map.put(_CS_V7_ENV, "_CS_V7_ENV");
  map.put(_CS_POSIX_V6_ILP32_OFF32_CFLAGS, "_CS_POSIX_V6_ILP32_OFF32_CFLAGS");
  map.put(_CS_POSIX_V6_ILP32_OFF32_LDFLAGS, "_CS_POSIX_V6_ILP32_OFF32_LDFLAGS");
  map.put(_CS_POSIX_V6_ILP32_OFF32_LIBS, "_CS_POSIX_V6_ILP32_OFF32_LIBS");
  map.put(_CS_POSIX_V6_ILP32_OFFBIG_CFLAGS, "_CS_POSIX_V6_ILP32_OFFBIG_CFLAGS");
  map.put(_CS_POSIX_V6_ILP32_OFFBIG_LDFLAGS, "_CS_POSIX_V6_ILP32_OFFBIG_LDFLAGS");
  map.put(_CS_POSIX_V6_ILP32_OFFBIG_LIBS, "_CS_POSIX_V6_ILP32_OFFBIG_LIBS");
  map.put(_CS_POSIX_V6_LP64_OFF64_CFLAGS, "_CS_POSIX_V6_LP64_OFF64_CFLAGS");
  map.put(_CS_POSIX_V6_LP64_OFF64_LDFLAGS, "_CS_POSIX_V6_LP64_OFF64_LDFLAGS");
  map.put(_CS_POSIX_V6_LP64_OFF64_LIBS, "_CS_POSIX_V6_LP64_OFF64_LIBS");
  map.put(_CS_POSIX_V6_LPBIG_OFFBIG_CFLAGS, "_CS_POSIX_V6_LPBIG_OFFBIG_CFLAGS");
  map.put(_CS_POSIX_V6_LPBIG_OFFBIG_LDFLAGS, "_CS_POSIX_V6_LPBIG_OFFBIG_LDFLAGS");
  map.put(_CS_POSIX_V6_LPBIG_OFFBIG_LIBS, "_CS_POSIX_V6_LPBIG_OFFBIG_LIBS");
  map.put(_CS_POSIX_V6_WIDTH_RESTRICTED_ENVS, "_CS_POSIX_V6_WIDTH_RESTRICTED_ENVS");
  map.put(_CS_V6_ENV, "_CS_V6_ENV");
    return map;
  }
}
public final String toString() { return StringTable.descriptions.get(this); }
public final int value() { return (int) value; }
public final int intValue() { return (int) value; }
public final long longValue() { return value; }
public final boolean defined() { return true; }
}
