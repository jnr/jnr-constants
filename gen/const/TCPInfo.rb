require_relative '../../gen/ConstGenerator'
def gen_tcpinfo_java(options)
  ConstGenerator.new 'platform.tcpinfo', options do |cg|
    cg.include "sys/socket.h"
    cg.include "sys/types.h"
    cg.include "netinet/tcp.h"
    %w[
      TCPI_OPT_TIMESTAMPS
      TCPI_OPT_SACK
      TCPI_OPT_WSCALE
      TCPI_OPT_ECN
      TCPI_OPT_ECN_SEEN
      TCPI_OPT_SYN_DATA
      TCPI_OPT_TOE
    ].each {|c| cg.const c, "%lu", "(unsigned long)"}
  end
end
