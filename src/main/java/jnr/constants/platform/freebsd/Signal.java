// WARNING: This file is autogenerated. DO NOT EDIT!
// Generated 2018-09-09 22:13:34 +0000
package jnr.constants.platform.freebsd;
public enum Signal implements jnr.constants.Constant {
SIGHUP(1L),
SIGINT(2L),
SIGQUIT(3L),
SIGILL(4L),
SIGTRAP(5L),
SIGABRT(6L),
SIGIOT(6L),
SIGBUS(10L),
SIGFPE(8L),
SIGKILL(9L),
SIGUSR1(30L),
SIGSEGV(11L),
SIGUSR2(31L),
SIGPIPE(13L),
SIGALRM(14L),
SIGTERM(15L),
// SIGSTKFLT not defined
// SIGCLD not defined
SIGCHLD(20L),
SIGCONT(19L),
SIGSTOP(17L),
SIGTSTP(18L),
SIGTTIN(21L),
SIGTTOU(22L),
SIGURG(16L),
SIGXCPU(24L),
SIGXFSZ(25L),
SIGVTALRM(26L),
SIGPROF(27L),
SIGWINCH(28L),
// SIGPOLL not defined
SIGIO(23L),
// SIGPWR not defined
SIGSYS(12L),
// SIGUNUSED not defined
SIGRTMIN(65L),
SIGRTMAX(126L),
NSIG(32L);
private final long value;
private Signal(long value) { this.value = value; }
public static final long MIN_VALUE = 1L;
public static final long MAX_VALUE = 126L;

public final int intValue() { return (int) value; }
public final long longValue() { return value; }
public final boolean defined() { return true; }
}
