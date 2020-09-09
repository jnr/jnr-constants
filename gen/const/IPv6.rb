require_relative '../../gen/ConstGenerator'
def gen_ipv6_java(options)
  ConstGenerator.new 'platform.ipv6', options do |cg|
    cg.include IS_WINDOWS ? "Ws2tcpip.h" : "netinet/in.h"
    %w[
      IPV6_JOIN_GROUP
      IPV6_LEAVE_GROUP
      IPV6_MULTICAST_HOPS
      IPV6_MULTICAST_IF
      IPV6_MULTICAST_LOOP
      IPV6_UNICAST_HOPS
      IPV6_V6ONLY
      IPV6_CHECKSUM
      IPV6_DONTFRAG
      IPV6_DSTOPTS
      IPV6_HOPLIMIT
      IPV6_HOPOPTS
      IPV6_NEXTHOP
      IPV6_PATHMTU
      IPV6_PKTINFO
      IPV6_RECVDSTOPTS
      IPV6_RECVHOPLIMIT
      IPV6_RECVHOPOPTS
      IPV6_RECVPKTINFO
      IPV6_RECVRTHDR
      IPV6_RECVTCLASS
      IPV6_RTHDR
      IPV6_RTHDRDSTOPTS
      IPV6_RTHDR_TYPE_0
      IPV6_RECVPATHMTU
      IPV6_TCLASS
      IPV6_USE_MIN_MTU
    ].each {|c| cg.const c, "%lu", "(unsigned long)"}
  end
end
