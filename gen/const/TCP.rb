require_relative '../../gen/ConstGenerator'
def gen_tcp_java(options)
  ConstGenerator.new 'platform.tcp', options do |cg|
    cg.include "sys/socket.h"
    cg.include "sys/types.h"
    cg.include "netinet/tcp.h"
    %w[
      TCP_MAX_SACK
      TCP_MSS
      TCP_MINMSS
      TCP_MINMSSOVERLOAD
      TCP_MAXWIN
      TCP_MAX_WINSHIFT
      TCP_MAXBURST
      TCP_MAXHLEN
      TCP_MAXOLEN
      TCP_NODELAY
      TCP_MAXSEG
      TCP_NOPUSH
      TCP_NOOPT
      TCP_KEEPALIVE
      TCP_NSTATES
      TCP_RETRANSHZ
    ].each {|c| cg.const c, "%lu", "(unsigned long)"}
  end
end
