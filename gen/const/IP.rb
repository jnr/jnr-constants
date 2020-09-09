require_relative '../../gen/ConstGenerator'
def gen_ip_java(options)
  ConstGenerator.new 'platform.ip', options do |cg|
    cg.include IS_WINDOWS ? "Iphlpapi.h" : "netinet/in.h"
    %w[
      IP_OPTIONS
      IP_HDRINCL
      IP_TOS
      IP_TTL
      IP_RECVOPTS
      IP_RECVRETOPTS
      IP_RECVDSTADDR
      IP_RETOPTS
      IP_MINTTL
      IP_DONTFRAG
      IP_SENDSRCADDR
      IP_ONESBCAST
      IP_RECVTTL
      IP_RECVIF
      IP_RECVSLLA
      IP_PORTRANGE
      IP_MULTICAST_IF
      IP_MULTICAST_TTL
      IP_MULTICAST_LOOP
      IP_ADD_MEMBERSHIP
      IP_DROP_MEMBERSHIP
      IP_DEFAULT_MULTICAST_TTL
      IP_DEFAULT_MULTICAST_LOOP
      IP_MAX_MEMBERSHIPS
      IP_ROUTER_ALERT
      IP_PKTINFO
      IP_PKTOPTIONS
      IP_MTU_DISCOVER
      IP_RECVERR
      IP_RECVTOS
      IP_MTU
      IP_FREEBIND
      IP_IPSEC_POLICY
      IP_XFRM_POLICY
      IP_PASSSEC
      IP_TRANSPARENT
      IP_PMTUDISC_DONT
      IP_PMTUDISC_WANT
      IP_PMTUDISC_DO
      IP_UNBLOCK_SOURCE
      IP_BLOCK_SOURCE
      IP_ADD_SOURCE_MEMBERSHIP
      IP_DROP_SOURCE_MEMBERSHIP
      IP_MSFILTER
    ].each {|c| cg.const c, "%lu", "(unsigned long)"}
  end
end
