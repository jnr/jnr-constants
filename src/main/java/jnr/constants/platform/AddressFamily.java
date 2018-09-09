// WARNING: This file is autogenerated. DO NOT EDIT!
// Generated 2018-09-08 09:14:53 +0200
package jnr.constants.platform;
public enum AddressFamily implements jnr.constants.Constant {
AF_UNSPEC,
AF_LOCAL,
AF_UNIX,
AF_INET,
AF_IMPLINK,
AF_PUP,
AF_CHAOS,
AF_NS,
AF_ISO,
AF_OSI,
AF_ECMA,
AF_DATAKIT,
AF_CCITT,
AF_SNA,
AF_DECnet,
AF_DLI,
AF_LAT,
AF_HYLINK,
AF_APPLETALK,
AF_ROUTE,
AF_LINK,
pseudo_AF_XTP,
AF_COIP,
AF_CNT,
pseudo_AF_RTIP,
AF_IPX,
AF_SIP,
pseudo_AF_PIP,
AF_NDRV,
AF_ISDN,
AF_E164,
pseudo_AF_KEY,
AF_INET6,
AF_NATM,
AF_SYSTEM,
AF_NETBIOS,
AF_PPP,
AF_ATM,
pseudo_AF_HDRCMPLT,
AF_NETGRAPH,
AF_AX25,
AF_MAX,
__UNKNOWN_CONSTANT__;
private static final ConstantResolver<AddressFamily> resolver = 
ConstantResolver.getResolver(AddressFamily.class, 20000, 29999);
public final int intValue() { return (int) resolver.longValue(this); }
public final long longValue() { return resolver.longValue(this); }
public final String description() { return resolver.description(this); }
public final boolean defined() { return resolver.defined(this); }
public final String toString() { return description(); }
public static AddressFamily valueOf(long value) { 
    return resolver.valueOf(value);
}
}
