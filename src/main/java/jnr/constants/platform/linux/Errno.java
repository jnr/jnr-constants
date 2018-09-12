// WARNING: This file is autogenerated. DO NOT EDIT!
// Generated 2017-07-30 01:16:56 +0000
package jnr.constants.platform.linux;
public enum Errno implements jnr.constants.Constant {
EPERM(1L),
ENOENT(2L),
ESRCH(3L),
EINTR(4L),
EIO(5L),
ENXIO(6L),
E2BIG(7L),
ENOEXEC(8L),
EBADF(9L),
ECHILD(10L),
EDEADLK(35L),
ENOMEM(12L),
EACCES(13L),
EFAULT(14L),
ENOTBLK(15L),
EBUSY(16L),
EEXIST(17L),
EXDEV(18L),
ENODEV(19L),
ENOTDIR(20L),
EISDIR(21L),
EINVAL(22L),
ENFILE(23L),
EMFILE(24L),
ENOTTY(25L),
ETXTBSY(26L),
EFBIG(27L),
ENOSPC(28L),
ESPIPE(29L),
EROFS(30L),
EMLINK(31L),
EPIPE(32L),
EDOM(33L),
ERANGE(34L),
EWOULDBLOCK(11L),
EAGAIN(11L),
EINPROGRESS(115L),
EALREADY(114L),
ENOTSOCK(88L),
EDESTADDRREQ(89L),
EMSGSIZE(90L),
EPROTOTYPE(91L),
ENOPROTOOPT(92L),
EPROTONOSUPPORT(93L),
ESOCKTNOSUPPORT(94L),
EOPNOTSUPP(95L),
EPFNOSUPPORT(96L),
EAFNOSUPPORT(97L),
EADDRINUSE(98L),
EADDRNOTAVAIL(99L),
ENETDOWN(100L),
ENETUNREACH(101L),
ENETRESET(102L),
ECONNABORTED(103L),
ECONNRESET(104L),
ENOBUFS(105L),
EISCONN(106L),
ENOTCONN(107L),
ESHUTDOWN(108L),
ETOOMANYREFS(109L),
ETIMEDOUT(110L),
ECONNREFUSED(111L),
ELOOP(40L),
ENAMETOOLONG(36L),
EHOSTDOWN(112L),
EHOSTUNREACH(113L),
ENOTEMPTY(39L),
EUSERS(87L),
EDQUOT(122L),
ESTALE(116L),
EREMOTE(66L),
ENOLCK(37L),
ENOSYS(38L),
EOVERFLOW(75L),
EIDRM(43L),
ENOMSG(42L),
EILSEQ(84L),
EBADMSG(74L),
EMULTIHOP(72L),
ENODATA(61L),
ENOLINK(67L),
ENOSR(63L),
ENOSTR(60L),
EPROTO(71L),
ETIME(62L);
private final long value;
private Errno(long value) { this.value = value; }
public static final long MIN_VALUE = 1L;
public static final long MAX_VALUE = 122L;

static final class StringTable {
  public static final java.util.Map<Errno, String> descriptions = generateTable();
  public static final java.util.Map<Errno, String> generateTable() {
    java.util.Map<Errno, String> map = new java.util.EnumMap<Errno, String>(Errno.class);
  map.put(EPERM, "Operation not permitted");
  map.put(ENOENT, "No such file or directory");
  map.put(ESRCH, "No such process");
  map.put(EINTR, "Interrupted system call");
  map.put(EIO, "Input/output error");
  map.put(ENXIO, "No such device or address");
  map.put(E2BIG, "Argument list too long");
  map.put(ENOEXEC, "Exec format error");
  map.put(EBADF, "Bad file descriptor");
  map.put(ECHILD, "No child processes");
  map.put(EDEADLK, "Resource deadlock avoided");
  map.put(ENOMEM, "Cannot allocate memory");
  map.put(EACCES, "Permission denied");
  map.put(EFAULT, "Bad address");
  map.put(ENOTBLK, "Block device required");
  map.put(EBUSY, "Device or resource busy");
  map.put(EEXIST, "File exists");
  map.put(EXDEV, "Invalid cross-device link");
  map.put(ENODEV, "No such device");
  map.put(ENOTDIR, "Not a directory");
  map.put(EISDIR, "Is a directory");
  map.put(EINVAL, "Invalid argument");
  map.put(ENFILE, "Too many open files in system");
  map.put(EMFILE, "Too many open files");
  map.put(ENOTTY, "Inappropriate ioctl for device");
  map.put(ETXTBSY, "Text file busy");
  map.put(EFBIG, "File too large");
  map.put(ENOSPC, "No space left on device");
  map.put(ESPIPE, "Illegal seek");
  map.put(EROFS, "Read-only file system");
  map.put(EMLINK, "Too many links");
  map.put(EPIPE, "Broken pipe");
  map.put(EDOM, "Numerical argument out of domain");
  map.put(ERANGE, "Numerical result out of range");
  map.put(EWOULDBLOCK, "Resource temporarily unavailable");
  map.put(EAGAIN, "Resource temporarily unavailable");
  map.put(EINPROGRESS, "Operation now in progress");
  map.put(EALREADY, "Operation already in progress");
  map.put(ENOTSOCK, "Socket operation on non-socket");
  map.put(EDESTADDRREQ, "Destination address required");
  map.put(EMSGSIZE, "Message too long");
  map.put(EPROTOTYPE, "Protocol wrong type for socket");
  map.put(ENOPROTOOPT, "Protocol not available");
  map.put(EPROTONOSUPPORT, "Protocol not supported");
  map.put(ESOCKTNOSUPPORT, "Socket type not supported");
  map.put(EOPNOTSUPP, "Operation not supported");
  map.put(EPFNOSUPPORT, "Protocol family not supported");
  map.put(EAFNOSUPPORT, "Address family not supported by protocol");
  map.put(EADDRINUSE, "Address already in use");
  map.put(EADDRNOTAVAIL, "Cannot assign requested address");
  map.put(ENETDOWN, "Network is down");
  map.put(ENETUNREACH, "Network is unreachable");
  map.put(ENETRESET, "Network dropped connection on reset");
  map.put(ECONNABORTED, "Software caused connection abort");
  map.put(ECONNRESET, "Connection reset by peer");
  map.put(ENOBUFS, "No buffer space available");
  map.put(EISCONN, "Transport endpoint is already connected");
  map.put(ENOTCONN, "Transport endpoint is not connected");
  map.put(ESHUTDOWN, "Cannot send after transport endpoint shutdown");
  map.put(ETOOMANYREFS, "Too many references: cannot splice");
  map.put(ETIMEDOUT, "Connection timed out");
  map.put(ECONNREFUSED, "Connection refused");
  map.put(ELOOP, "Too many levels of symbolic links");
  map.put(ENAMETOOLONG, "File name too long");
  map.put(EHOSTDOWN, "Host is down");
  map.put(EHOSTUNREACH, "No route to host");
  map.put(ENOTEMPTY, "Directory not empty");
  map.put(EUSERS, "Too many users");
  map.put(EDQUOT, "Disk quota exceeded");
  map.put(ESTALE, "Stale file handle");
  map.put(EREMOTE, "Object is remote");
  map.put(ENOLCK, "No locks available");
  map.put(ENOSYS, "Function not implemented");
  map.put(EOVERFLOW, "Value too large for defined data type");
  map.put(EIDRM, "Identifier removed");
  map.put(ENOMSG, "No message of desired type");
  map.put(EILSEQ, "Invalid or incomplete multibyte or wide character");
  map.put(EBADMSG, "Bad message");
  map.put(EMULTIHOP, "Multihop attempted");
  map.put(ENODATA, "No data available");
  map.put(ENOLINK, "Link has been severed");
  map.put(ENOSR, "Out of streams resources");
  map.put(ENOSTR, "Device not a stream");
  map.put(EPROTO, "Protocol error");
  map.put(ETIME, "Timer expired");
    return map;
  }
}
public final String toString() { return StringTable.descriptions.get(this); }
public final int intValue() { return (int) value; }
public final long longValue() { return value; }
public final boolean defined() { return true; }
}
