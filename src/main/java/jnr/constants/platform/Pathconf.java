// WARNING: This file is autogenerated. DO NOT EDIT!
// Generated 2020-06-04 16:58:20 +0200
package jnr.constants.platform;
public enum Pathconf implements jnr.constants.Constant {
_PC_FILESIZEBITS,
_PC_LINK_MAX,
_PC_MAX_CANON,
_PC_MAX_INPUT,
_PC_NAME_MAX,
_PC_PATH_MAX,
_PC_PIPE_BUF,
_PC_2_SYMLINKS,
_PC_ALLOC_SIZE_MIN,
_PC_REC_INCR_XFER_SIZE,
_PC_REC_MAX_XFER_SIZE,
_PC_REC_MIN_XFER_SIZE,
_PC_REC_XFER_ALIGN,
_PC_SYMLINK_MAX,
_PC_CHOWN_RESTRICTED,
_PC_NO_TRUNC,
_PC_VDISABLE,
_PC_ASYNC_IO,
_PC_PRIO_IO,
_PC_SYNC_IO,
__UNKNOWN_CONSTANT__;
private static final ConstantResolver<Pathconf> resolver = 
ConstantResolver.getResolver(Pathconf.class, 20000, 29999);
public final int value() { return (int) resolver.longValue(this); }
public final int intValue() { return (int) resolver.longValue(this); }
public final long longValue() { return resolver.longValue(this); }
public final String description() { return resolver.description(this); }
public final boolean defined() { return resolver.defined(this); }
public final String toString() { return description(); }
public static Pathconf valueOf(long value) { 
    return resolver.valueOf(value);
}
}
