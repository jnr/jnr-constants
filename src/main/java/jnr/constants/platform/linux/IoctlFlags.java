// WARNING: This file is autogenerated. DO NOT EDIT!
// Generated 2018-03-31 10:23:21 +0200
package jnr.constants.platform.linux;
public enum IoctlFlags implements jnr.constants.Constant {
TCGETS(21505L),
TCSETS(21506L),
TCSETSW(21507L),
TCSETSF(21508L),
TCGETA(21509L),
TCSETA(21510L),
TCSETAW(21511L),
TCSETAF(21512L),
TCSBRK(21513L),
TCXONC(21514L),
TCFLSH(21515L),
TIOCEXCL(21516L),
TIOCNXCL(21517L),
TIOCSCTTY(21518L),
TIOCGPGRP(21519L),
TIOCSPGRP(21520L),
TIOCOUTQ(21521L),
TIOCSTI(21522L),
TIOCGWINSZ(21523L),
TIOCSWINSZ(21524L),
TIOCMGET(21525L),
TIOCMBIS(21526L),
TIOCMBIC(21527L),
TIOCMSET(21528L),
TIOCGSOFTCAR(21529L),
TIOCSSOFTCAR(21530L),
FIONREAD(21531L),
TIOCINQ(21531L),
TIOCLINUX(21532L),
TIOCCONS(21533L),
TIOCGSERIAL(21534L),
TIOCSSERIAL(21535L),
TIOCPKT(21536L),
FIONBIO(21537L),
TIOCNOTTY(21538L),
TIOCSETD(21539L),
TIOCGETD(21540L),
TCSBRKP(21541L),
TIOCSBRK(21543L),
TIOCCBRK(21544L),
TIOCGSID(21545L),
TIOCGRS485(21550L),
TIOCSRS485(21551L),
TCGETX(21554L),
TCSETX(21555L),
TCSETXF(21556L),
TCSETXW(21557L),
TIOCVHANGUP(21559L),
TIOCGPTPEER(21569L),
FIONCLEX(21584L),
FIOCLEX(21585L),
FIOASYNC(21586L),
TIOCSERCONFIG(21587L),
TIOCSERGWILD(21588L),
TIOCSERSWILD(21589L),
TIOCGLCKTRMIOS(21590L),
TIOCSLCKTRMIOS(21591L),
TIOCSERGSTRUCT(21592L),
TIOCSERGETLSR(21593L),
TIOCSERGETMULTI(21594L),
TIOCSERSETMULTI(21595L),
TIOCMIWAIT(21596L),
TIOCGICOUNT(21597L),
FIOQSIZE(21600L),
TIOCPKT_DATA(0L),
TIOCPKT_FLUSHREAD(1L),
TIOCPKT_FLUSHWRITE(2L),
TIOCPKT_STOP(4L),
TIOCPKT_START(8L),
TIOCPKT_NOSTOP(16L),
TIOCPKT_DOSTOP(32L),
TIOCPKT_IOCTL(64L),
TIOCSER_TEMT(1L);
private final long value;
private IoctlFlags(long value) { this.value = value; }
public static final long MIN_VALUE = 0L;
public static final long MAX_VALUE = 21600L;

public final int intValue() { return (int) value; }
public final long longValue() { return value; }
public final boolean defined() { return true; }
}
