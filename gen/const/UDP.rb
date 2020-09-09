require_relative '../../gen/ConstGenerator'
def gen_udp_java(options)
  ConstGenerator.new 'platform.udp', options do |cg|
    cg.include "sys/socket.h"
    cg.include "sys/types.h"
    cg.include "netinet/udp.h"
    %w[
      UDP_CORK
    ].each {|c| cg.const c, "%lu", "(unsigned long)"}
  end
end
