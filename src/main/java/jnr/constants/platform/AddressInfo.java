// WARNING: This file is autogenerated. DO NOT EDIT!
// Generated 2020-09-03 01:01:38 +0200
package jnr.constants.platform;
public enum AddressInfo implements jnr.constants.Constant {
AI_PASSIVE,
AI_CANONNAME,
AI_NUMERICHOST,
AI_NUMERICSERV,
AI_MASK,
AI_ALL,
AI_V4MAPPED_CFG,
AI_ADDRCONFIG,
AI_V4MAPPED,
AI_DEFAULT,
__UNKNOWN_CONSTANT__;
private static final ConstantResolver<AddressInfo> resolver = 
ConstantResolver.getResolver(AddressInfo.class, 20000, 29999);
public final int value() { return (int) resolver.longValue(this); }
public final int intValue() { return (int) resolver.longValue(this); }
public final long longValue() { return resolver.longValue(this); }
public final String description() { return resolver.description(this); }
public final boolean defined() { return resolver.defined(this); }
public final String toString() { return description(); }
public static AddressInfo valueOf(long value) { 
    return resolver.valueOf(value);
}
}