// WARNING: This file is autogenerated. DO NOT EDIT!
// Generated 2021-06-03 02:37:56 +0000
package jnr.constants.platform.linux.powerpc64;
public enum Signal implements jnr.constants.Constant {
SIGHUP(1L),
SIGINT(2L),
SIGQUIT(3L),
SIGILL(4L),
SIGTRAP(5L),
SIGABRT(6L),
SIGIOT(6L),
SIGBUS(7L),
SIGFPE(8L),
SIGKILL(9L),
SIGUSR1(10L),
SIGSEGV(11L),
SIGUSR2(12L),
SIGPIPE(13L),
SIGALRM(14L),
SIGTERM(15L),
SIGSTKFLT(16L),
SIGCLD(17L),
SIGCHLD(17L),
SIGCONT(18L),
SIGSTOP(19L),
SIGTSTP(20L),
SIGTTIN(21L),
SIGTTOU(22L),
SIGURG(23L),
SIGXCPU(24L),
SIGXFSZ(25L),
SIGVTALRM(26L),
SIGPROF(27L),
SIGWINCH(28L),
SIGPOLL(29L),
SIGIO(29L),
SIGPWR(30L),
SIGSYS(31L),
// SIGUNUSED not defined
SIGRTMIN(34L),
SIGRTMAX(64L),
NSIG(65L);
private final long value;
private Signal(long value) { this.value = value; }
public static final long MIN_VALUE = 1L;
public static final long MAX_VALUE = 65L;

static final class StringTable {
  public static final java.util.Map<Signal, String> descriptions = generateTable();
  public static final java.util.Map<Signal, String> generateTable() {
    java.util.Map<Signal, String> map = new java.util.EnumMap<Signal, String>(Signal.class);
  map.put(SIGHUP, "SIGHUP");
  map.put(SIGINT, "SIGINT");
  map.put(SIGQUIT, "SIGQUIT");
  map.put(SIGILL, "SIGILL");
  map.put(SIGTRAP, "SIGTRAP");
  map.put(SIGABRT, "SIGABRT");
  map.put(SIGIOT, "SIGIOT");
  map.put(SIGBUS, "SIGBUS");
  map.put(SIGFPE, "SIGFPE");
  map.put(SIGKILL, "SIGKILL");
  map.put(SIGUSR1, "SIGUSR1");
  map.put(SIGSEGV, "SIGSEGV");
  map.put(SIGUSR2, "SIGUSR2");
  map.put(SIGPIPE, "SIGPIPE");
  map.put(SIGALRM, "SIGALRM");
  map.put(SIGTERM, "SIGTERM");
  map.put(SIGSTKFLT, "SIGSTKFLT");
  map.put(SIGCLD, "SIGCLD");
  map.put(SIGCHLD, "SIGCHLD");
  map.put(SIGCONT, "SIGCONT");
  map.put(SIGSTOP, "SIGSTOP");
  map.put(SIGTSTP, "SIGTSTP");
  map.put(SIGTTIN, "SIGTTIN");
  map.put(SIGTTOU, "SIGTTOU");
  map.put(SIGURG, "SIGURG");
  map.put(SIGXCPU, "SIGXCPU");
  map.put(SIGXFSZ, "SIGXFSZ");
  map.put(SIGVTALRM, "SIGVTALRM");
  map.put(SIGPROF, "SIGPROF");
  map.put(SIGWINCH, "SIGWINCH");
  map.put(SIGPOLL, "SIGPOLL");
  map.put(SIGIO, "SIGIO");
  map.put(SIGPWR, "SIGPWR");
  map.put(SIGSYS, "SIGSYS");
  map.put(SIGRTMIN, "SIGRTMIN");
  map.put(SIGRTMAX, "SIGRTMAX");
  map.put(NSIG, "NSIG");
    return map;
  }
}
public final String toString() { return StringTable.descriptions.get(this); }
public final int value() { return (int) value; }
public final int intValue() { return (int) value; }
public final long longValue() { return value; }
public final boolean defined() { return true; }
}