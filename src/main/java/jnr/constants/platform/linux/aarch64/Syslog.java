// WARNING: This file is autogenerated. DO NOT EDIT!
// Generated 2021-09-16 23:29:19 +0200
package jnr.constants.platform.linux.aarch64;
public enum Syslog implements jnr.constants.Constant {
LOG_ALERT(1L),
LOG_AUTH(32L),
LOG_AUTHPRIV(80L),
LOG_CONS(2L),
// LOG_CONSOLE not defined
LOG_CRIT(2L),
LOG_CRON(72L),
LOG_DAEMON(24L),
LOG_DEBUG(7L),
LOG_EMERG(0L),
LOG_ERR(3L),
LOG_FTP(88L),
LOG_INFO(6L),
LOG_KERN(0L),
LOG_LOCAL0(128L),
LOG_LOCAL1(136L),
LOG_LOCAL2(144L),
LOG_LOCAL3(152L),
LOG_LOCAL4(160L),
LOG_LOCAL5(168L),
LOG_LOCAL6(176L),
LOG_LOCAL7(184L),
LOG_LPR(48L),
LOG_MAIL(16L),
LOG_NDELAY(8L),
LOG_NEWS(56L),
LOG_NOTICE(5L),
LOG_NOWAIT(16L),
// LOG_NTP not defined
LOG_ODELAY(4L),
LOG_PERROR(32L),
LOG_PID(1L),
// LOG_SECURITY not defined
LOG_SYSLOG(40L),
LOG_USER(8L),
LOG_UUCP(64L),
LOG_WARNING(4L);
private final long value;
private Syslog(long value) { this.value = value; }
public static final long MIN_VALUE = 0L;
public static final long MAX_VALUE = 184L;

static final class StringTable {
  public static final java.util.Map<Syslog, String> descriptions = generateTable();
  public static final java.util.Map<Syslog, String> generateTable() {
    java.util.Map<Syslog, String> map = new java.util.EnumMap<Syslog, String>(Syslog.class);
  map.put(LOG_ALERT, "LOG_ALERT");
  map.put(LOG_AUTH, "LOG_AUTH");
  map.put(LOG_AUTHPRIV, "LOG_AUTHPRIV");
  map.put(LOG_CONS, "LOG_CONS");
  map.put(LOG_CRIT, "LOG_CRIT");
  map.put(LOG_CRON, "LOG_CRON");
  map.put(LOG_DAEMON, "LOG_DAEMON");
  map.put(LOG_DEBUG, "LOG_DEBUG");
  map.put(LOG_EMERG, "LOG_EMERG");
  map.put(LOG_ERR, "LOG_ERR");
  map.put(LOG_FTP, "LOG_FTP");
  map.put(LOG_INFO, "LOG_INFO");
  map.put(LOG_KERN, "LOG_KERN");
  map.put(LOG_LOCAL0, "LOG_LOCAL0");
  map.put(LOG_LOCAL1, "LOG_LOCAL1");
  map.put(LOG_LOCAL2, "LOG_LOCAL2");
  map.put(LOG_LOCAL3, "LOG_LOCAL3");
  map.put(LOG_LOCAL4, "LOG_LOCAL4");
  map.put(LOG_LOCAL5, "LOG_LOCAL5");
  map.put(LOG_LOCAL6, "LOG_LOCAL6");
  map.put(LOG_LOCAL7, "LOG_LOCAL7");
  map.put(LOG_LPR, "LOG_LPR");
  map.put(LOG_MAIL, "LOG_MAIL");
  map.put(LOG_NDELAY, "LOG_NDELAY");
  map.put(LOG_NEWS, "LOG_NEWS");
  map.put(LOG_NOTICE, "LOG_NOTICE");
  map.put(LOG_NOWAIT, "LOG_NOWAIT");
  map.put(LOG_ODELAY, "LOG_ODELAY");
  map.put(LOG_PERROR, "LOG_PERROR");
  map.put(LOG_PID, "LOG_PID");
  map.put(LOG_SYSLOG, "LOG_SYSLOG");
  map.put(LOG_USER, "LOG_USER");
  map.put(LOG_UUCP, "LOG_UUCP");
  map.put(LOG_WARNING, "LOG_WARNING");
    return map;
  }
}
public final String toString() { return StringTable.descriptions.get(this); }
public final int value() { return (int) value; }
public final int intValue() { return (int) value; }
public final long longValue() { return value; }
public final boolean defined() { return true; }
}