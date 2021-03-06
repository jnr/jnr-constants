// WARNING: This file is autogenerated. DO NOT EDIT!
// Generated 2021-06-03 02:37:30 +0000
package jnr.constants.platform.linux.aarch64;
public enum IP implements jnr.constants.Constant {
IP_OPTIONS(4L),
IP_HDRINCL(3L),
IP_TOS(1L),
IP_TTL(2L),
IP_RECVOPTS(6L),
IP_RECVRETOPTS(7L),
// IP_RECVDSTADDR not defined
IP_RETOPTS(7L),
IP_MINTTL(21L),
// IP_DONTFRAG not defined
// IP_SENDSRCADDR not defined
// IP_ONESBCAST not defined
IP_RECVTTL(12L),
// IP_RECVIF not defined
// IP_RECVSLLA not defined
// IP_PORTRANGE not defined
IP_MULTICAST_IF(32L),
IP_MULTICAST_TTL(33L),
IP_MULTICAST_LOOP(34L),
IP_ADD_MEMBERSHIP(35L),
IP_DROP_MEMBERSHIP(36L),
IP_DEFAULT_MULTICAST_TTL(1L),
IP_DEFAULT_MULTICAST_LOOP(1L),
IP_MAX_MEMBERSHIPS(20L),
IP_ROUTER_ALERT(5L),
IP_PKTINFO(8L),
IP_PKTOPTIONS(9L),
IP_MTU_DISCOVER(10L),
IP_RECVERR(11L),
IP_RECVTOS(13L),
IP_MTU(14L),
IP_FREEBIND(15L),
IP_IPSEC_POLICY(16L),
IP_XFRM_POLICY(17L),
IP_PASSSEC(18L),
IP_TRANSPARENT(19L),
IP_PMTUDISC_DONT(0L),
IP_PMTUDISC_WANT(1L),
IP_PMTUDISC_DO(2L),
IP_UNBLOCK_SOURCE(37L),
IP_BLOCK_SOURCE(38L),
IP_ADD_SOURCE_MEMBERSHIP(39L),
IP_DROP_SOURCE_MEMBERSHIP(40L),
IP_MSFILTER(41L);
private final long value;
private IP(long value) { this.value = value; }
public static final long MIN_VALUE = 0L;
public static final long MAX_VALUE = 41L;

static final class StringTable {
  public static final java.util.Map<IP, String> descriptions = generateTable();
  public static final java.util.Map<IP, String> generateTable() {
    java.util.Map<IP, String> map = new java.util.EnumMap<IP, String>(IP.class);
  map.put(IP_OPTIONS, "IP_OPTIONS");
  map.put(IP_HDRINCL, "IP_HDRINCL");
  map.put(IP_TOS, "IP_TOS");
  map.put(IP_TTL, "IP_TTL");
  map.put(IP_RECVOPTS, "IP_RECVOPTS");
  map.put(IP_RECVRETOPTS, "IP_RECVRETOPTS");
  map.put(IP_RETOPTS, "IP_RETOPTS");
  map.put(IP_MINTTL, "IP_MINTTL");
  map.put(IP_RECVTTL, "IP_RECVTTL");
  map.put(IP_MULTICAST_IF, "IP_MULTICAST_IF");
  map.put(IP_MULTICAST_TTL, "IP_MULTICAST_TTL");
  map.put(IP_MULTICAST_LOOP, "IP_MULTICAST_LOOP");
  map.put(IP_ADD_MEMBERSHIP, "IP_ADD_MEMBERSHIP");
  map.put(IP_DROP_MEMBERSHIP, "IP_DROP_MEMBERSHIP");
  map.put(IP_DEFAULT_MULTICAST_TTL, "IP_DEFAULT_MULTICAST_TTL");
  map.put(IP_DEFAULT_MULTICAST_LOOP, "IP_DEFAULT_MULTICAST_LOOP");
  map.put(IP_MAX_MEMBERSHIPS, "IP_MAX_MEMBERSHIPS");
  map.put(IP_ROUTER_ALERT, "IP_ROUTER_ALERT");
  map.put(IP_PKTINFO, "IP_PKTINFO");
  map.put(IP_PKTOPTIONS, "IP_PKTOPTIONS");
  map.put(IP_MTU_DISCOVER, "IP_MTU_DISCOVER");
  map.put(IP_RECVERR, "IP_RECVERR");
  map.put(IP_RECVTOS, "IP_RECVTOS");
  map.put(IP_MTU, "IP_MTU");
  map.put(IP_FREEBIND, "IP_FREEBIND");
  map.put(IP_IPSEC_POLICY, "IP_IPSEC_POLICY");
  map.put(IP_XFRM_POLICY, "IP_XFRM_POLICY");
  map.put(IP_PASSSEC, "IP_PASSSEC");
  map.put(IP_TRANSPARENT, "IP_TRANSPARENT");
  map.put(IP_PMTUDISC_DONT, "IP_PMTUDISC_DONT");
  map.put(IP_PMTUDISC_WANT, "IP_PMTUDISC_WANT");
  map.put(IP_PMTUDISC_DO, "IP_PMTUDISC_DO");
  map.put(IP_UNBLOCK_SOURCE, "IP_UNBLOCK_SOURCE");
  map.put(IP_BLOCK_SOURCE, "IP_BLOCK_SOURCE");
  map.put(IP_ADD_SOURCE_MEMBERSHIP, "IP_ADD_SOURCE_MEMBERSHIP");
  map.put(IP_DROP_SOURCE_MEMBERSHIP, "IP_DROP_SOURCE_MEMBERSHIP");
  map.put(IP_MSFILTER, "IP_MSFILTER");
    return map;
  }
}
public final String toString() { return StringTable.descriptions.get(this); }
public final int value() { return (int) value; }
public final int intValue() { return (int) value; }
public final long longValue() { return value; }
public final boolean defined() { return true; }
}
