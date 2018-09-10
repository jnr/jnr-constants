// WARNING: This file is autogenerated. DO NOT EDIT!
// Generated 2018-09-09 22:13:53 +0000
package jnr.constants.platform;
public enum Errno implements jnr.constants.Constant {
EPERM,
ENOENT,
ESRCH,
EINTR,
EIO,
ENXIO,
E2BIG,
ENOEXEC,
EBADF,
ECHILD,
EAGAIN,
ENOMEM,
EACCES,
EFAULT,
ENOTBLK,
EBUSY,
EEXIST,
EXDEV,
ENODEV,
ENOTDIR,
EISDIR,
EINVAL,
ENFILE,
EMFILE,
ENOTTY,
ETXTBSY,
EFBIG,
ENOSPC,
ESPIPE,
EROFS,
EMLINK,
EPIPE,
EDOM,
ERANGE,
EDEADLK,
ENAMETOOLONG,
ENOLCK,
ENOSYS,
ENOTEMPTY,
ELOOP,
EWOULDBLOCK,
ENOMSG,
EIDRM,
ECHRNG,
EL2NSYNC,
EL3HLT,
EL3RST,
ELNRNG,
EUNATCH,
ENOCSI,
EL2HLT,
EBADE,
EBADR,
EXFULL,
ENOANO,
EBADRQC,
EBADSLT,
EDEADLOCK,
EBFONT,
ENOSTR,
ENODATA,
ETIME,
ENOSR,
ENONET,
ENOPKG,
EREMOTE,
ENOLINK,
EADV,
ESRMNT,
ECOMM,
EPROTO,
EMULTIHOP,
EDOTDOT,
EBADMSG,
EOVERFLOW,
ENOTUNIQ,
EBADFD,
EREMCHG,
ELIBACC,
ELIBBAD,
ELIBSCN,
ELIBMAX,
ELIBEXEC,
EILSEQ,
ERESTART,
ESTRPIPE,
EUSERS,
ENOTSOCK,
EDESTADDRREQ,
EMSGSIZE,
EPROTOTYPE,
ENOPROTOOPT,
EPROTONOSUPPORT,
ESOCKTNOSUPPORT,
EOPNOTSUPP,
EPFNOSUPPORT,
EAFNOSUPPORT,
EADDRINUSE,
EADDRNOTAVAIL,
ENETDOWN,
ENETUNREACH,
ENETRESET,
ECONNABORTED,
ECONNRESET,
ENOBUFS,
EISCONN,
ENOTCONN,
ESHUTDOWN,
ETOOMANYREFS,
ETIMEDOUT,
ECONNREFUSED,
EHOSTDOWN,
EHOSTUNREACH,
EALREADY,
EINPROGRESS,
ESTALE,
EUCLEAN,
ENOTNAM,
ENAVAIL,
EISNAM,
EREMOTEIO,
EDQUOT,
ECANCELED,
EKEYEXPIRED,
EKEYREJECTED,
EKEYREVOKED,
EMEDIUMTYPE,
ENOKEY,
ENOMEDIUM,
ENOTRECOVERABLE,
EOWNERDEAD,
ERFKILL,
EAUTH,
EBADRPC,
EDOOFUS,
EFTYPE,
ENEEDAUTH,
ENOATTR,
ENOTSUP,
EPROCLIM,
EPROCUNAVAIL,
EPROGMISMATCH,
EPROGUNAVAIL,
ERPCMISMATCH,
EIPSEC,
EHWPOISON,
ECAPMODE,
ENOTCAPABLE,
__UNKNOWN_CONSTANT__;
private static final ConstantResolver<Errno> resolver = 
ConstantResolver.getResolver(Errno.class, 20000, 20999);
public final int intValue() { return (int) resolver.longValue(this); }
public final long longValue() { return resolver.longValue(this); }
public final String description() { return resolver.description(this); }
public final boolean defined() { return resolver.defined(this); }
public final String toString() { return description(); }
public static Errno valueOf(long value) { 
    return resolver.valueOf(value);
}
}
