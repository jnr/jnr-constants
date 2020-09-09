require_relative '../../gen/ConstGenerator'
def gen_addressinfo_java(options)
  ConstGenerator.new 'platform.address_info', options do |cg|
    cg.include IS_WINDOWS ? "Ws2tcpip.h" : "netdb.h"
    %w[
      AI_PASSIVE
      AI_CANONNAME
      AI_NUMERICHOST
      AI_NUMERICSERV
      AI_MASK
      AI_ALL
      AI_V4MAPPED_CFG
      AI_ADDRCONFIG
      AI_V4MAPPED
      AI_DEFAULT
    ].each {|c| cg.const c }
  end
end
