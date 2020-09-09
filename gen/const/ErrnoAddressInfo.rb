require_relative '../../gen/ConstGenerator'
def gen_errnoaddressinfo_java(options)
  ConstGenerator.new 'platform.errno_address_info', options do |cg|
    cg.include IS_WINDOWS ? "Ws2tcpip.h" : "netdb.h"
    cg.define _GNU_SOURCE: 1
    %w[
      EAI_ADDRFAMILY
      EAI_AGAIN
      EAI_BADFLAGS
      EAI_FAIL
      EAI_FAMILY
      EAI_MEMORY
      EAI_NODATA
      EAI_NONAME
      EAI_OVERFLOW
      EAI_SERVICE
      EAI_SOCKTYPE
      EAI_SYSTEM
      EAI_BADHINTS
      EAI_PROTOCOL
      EAI_MAX
    ].each { |c| cg.const(c, '%ld', '(long int)') }
  end
end
