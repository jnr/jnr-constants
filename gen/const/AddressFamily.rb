require_relative '../../gen/ConstGenerator'
def gen_addressfamily_java(options)
  ConstGenerator.new 'platform.address_family', options do |cg|
    cg.include IS_WINDOWS ? "Winsock2.h" : "sys/socket.h"
    %w[
      AF_UNSPEC
      AF_LOCAL
      AF_UNIX
      AF_INET
      AF_IMPLINK
      AF_PUP
      AF_CHAOS
      AF_NS
      AF_ISO
      AF_OSI
      AF_ECMA
      AF_DATAKIT
      AF_CCITT
      AF_SNA
      AF_DECnet
      AF_DLI
      AF_LAT
      AF_HYLINK
      AF_APPLETALK
      AF_ROUTE
      AF_LINK
      pseudo_AF_XTP
      AF_COIP
      AF_CNT
      pseudo_AF_RTIP
      AF_IPX
      AF_SIP
      pseudo_AF_PIP
      AF_NDRV
      AF_ISDN
      AF_E164
      pseudo_AF_KEY
      AF_INET6
      AF_NATM
      AF_SYSTEM
      AF_NETBIOS
      AF_PPP
      AF_ATM
      pseudo_AF_HDRCMPLT
      AF_NETGRAPH
      AF_AX25
      AF_MAX
    ].each {|c| cg.const c }
  end
end
