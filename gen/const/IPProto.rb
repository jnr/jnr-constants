require_relative '../../gen/ConstGenerator'
def gen_ipproto_java(options)
  ConstGenerator.new 'platform.ipproto', options do |cg|
    cg.include IS_WINDOWS ? "Winsock2.h" : "netinet/in.h"
    %w[
      IPPROTO_IP
      IPPROTO_HOPOPTS
      IPPROTO_ICMP
      IPPROTO_IGMP
      IPPROTO_IPIP
      IPPROTO_TCP
      IPPROTO_EGP
      IPPROTO_PUP
      IPPROTO_UDP
      IPPROTO_IDP
      IPPROTO_TP
      IPPROTO_IPV6
      IPPROTO_ROUTING
      IPPROTO_FRAGMENT
      IPPROTO_RSVP
      IPPROTO_GRE
      IPPROTO_ESP
      IPPROTO_AH
      IPPROTO_ICMPV6
      IPPROTO_NONE
      IPPROTO_DSTOPTS
      IPPROTO_MTP
      IPPROTO_ENCAP
      IPPROTO_PIM
      IPPROTO_COMP
      IPPROTO_SCTP
      IPPROTO_RAW
      IPPROTO_MAX
    ].each {|c| cg.const c}
  end
end
