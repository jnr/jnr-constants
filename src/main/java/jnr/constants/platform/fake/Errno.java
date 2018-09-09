// WARNING: This file is autogenerated. DO NOT EDIT!
// Generated 2018-09-09 19:50:30 +0200
package jnr.constants.platform.fake;
public enum Errno implements jnr.constants.Constant {
EPERM(1),
ENOENT(2),
ESRCH(3),
EINTR(4),
EIO(5),
ENXIO(6),
E2BIG(7),
ENOEXEC(8),
EBADF(9),
ECHILD(10),
EAGAIN(11),
ENOMEM(12),
EACCES(13),
EFAULT(14),
ENOTBLK(15),
EBUSY(16),
EEXIST(17),
EXDEV(18),
ENODEV(19),
ENOTDIR(20),
EISDIR(21),
EINVAL(22),
ENFILE(23),
EMFILE(24),
ENOTTY(25),
ETXTBSY(26),
EFBIG(27),
ENOSPC(28),
ESPIPE(29),
EROFS(30),
EMLINK(31),
EPIPE(32),
EDOM(33),
ERANGE(34),
EDEADLK(35),
ENAMETOOLONG(36),
ENOLCK(37),
ENOSYS(38),
ENOTEMPTY(39),
ELOOP(40),
EWOULDBLOCK(41),
ENOMSG(42),
EIDRM(43),
ECHRNG(44),
EL2NSYNC(45),
EL3HLT(46),
EL3RST(47),
ELNRNG(48),
EUNATCH(49),
ENOCSI(50),
EL2HLT(51),
EBADE(52),
EBADR(53),
EXFULL(54),
ENOANO(55),
EBADRQC(56),
EBADSLT(57),
EDEADLOCK(58),
EBFONT(59),
ENOSTR(60),
ENODATA(61),
ETIME(62),
ENOSR(63),
ENONET(64),
ENOPKG(65),
EREMOTE(66),
ENOLINK(67),
EADV(68),
ESRMNT(69),
ECOMM(70),
EPROTO(71),
EMULTIHOP(72),
EDOTDOT(73),
EBADMSG(74),
EOVERFLOW(75),
ENOTUNIQ(76),
EBADFD(77),
EREMCHG(78),
ELIBACC(79),
ELIBBAD(80),
ELIBSCN(81),
ELIBMAX(82),
ELIBEXEC(83),
EILSEQ(84),
ERESTART(85),
ESTRPIPE(86),
EUSERS(87),
ENOTSOCK(88),
EDESTADDRREQ(89),
EMSGSIZE(90),
EPROTOTYPE(91),
ENOPROTOOPT(92),
EPROTONOSUPPORT(93),
ESOCKTNOSUPPORT(94),
EOPNOTSUPP(95),
EPFNOSUPPORT(96),
EAFNOSUPPORT(97),
EADDRINUSE(98),
EADDRNOTAVAIL(99),
ENETDOWN(100),
ENETUNREACH(101),
ENETRESET(102),
ECONNABORTED(103),
ECONNRESET(104),
ENOBUFS(105),
EISCONN(106),
ENOTCONN(107),
ESHUTDOWN(108),
ETOOMANYREFS(109),
ETIMEDOUT(110),
ECONNREFUSED(111),
EHOSTDOWN(112),
EHOSTUNREACH(113),
EALREADY(114),
EINPROGRESS(115),
ESTALE(116),
EUCLEAN(117),
ENOTNAM(118),
ENAVAIL(119),
EISNAM(120),
EREMOTEIO(121),
EDQUOT(122),
ECANCELED(123),
EKEYEXPIRED(124),
EKEYREJECTED(125),
EKEYREVOKED(126),
EMEDIUMTYPE(127),
ENOKEY(128),
ENOMEDIUM(129),
ENOTRECOVERABLE(130),
EOWNERDEAD(131),
ERFKILL(132),
EAUTH(133),
EBADRPC(134),
EDOOFUS(135),
EFTYPE(136),
ENEEDAUTH(137),
ENOATTR(138),
ENOTSUP(139),
EPROCLIM(140),
EPROCUNAVAIL(141),
EPROGMISMATCH(142),
EPROGUNAVAIL(143),
ERPCMISMATCH(144),
EIPSEC(145),
EHWPOISON(146),
ECAPMODE(147),
ENOTCAPABLE(148);
private final long value;
private Errno(long value) { this.value = value; }
public static final long MIN_VALUE = 1L;
public static final long MAX_VALUE = 148L;
public final int intValue() { return (int) value; }
public final long longValue() { return value; }
public final boolean defined() { return true; }
}
