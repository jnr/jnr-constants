require_relative '../../gen/ConstGenerator'
def gen_protocolfamily_java(options)
  ConstGenerator.new 'platform.protocol_family', options do |cg|
    cg.include IS_WINDOWS ? "Winsock2.h" : "sys/socket.h"
    %w[
      PF_UNSPEC
      PF_LOCAL
      PF_UNIX
      PF_INET
      PF_IMPLINK
      PF_PUP
      PF_CHAOS
      PF_NS
      PF_ISO
      PF_OSI
      PF_ECMA
      PF_DATAKIT
      PF_CCITT
      PF_SNA
      PF_DECnet
      PF_DLI
      PF_LAT
      PF_HYLINK
      PF_APPLETALK
      PF_ROUTE
      PF_LINK
      PF_XTP
      PF_COIP
      PF_CNT
      PF_SIP
      PF_IPX
      PF_RTIP
      PF_PIP
      PF_NDRV
      PF_ISDN
      PF_KEY
      PF_INET6
      PF_NATM
      PF_SYSTEM
      PF_NETBIOS
      PF_PPP
      PF_ATM
      PF_NETGRAPH
      PF_MAX
    ].each {|c| cg.const c}
  end
end
