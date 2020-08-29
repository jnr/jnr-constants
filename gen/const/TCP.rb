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
      TCP_CORK
      TCP_DEFER_ACCEPT
      TCP_INFO
      TCP_KEEPCNT
      TCP_KEEPIDLE
      TCP_KEEPINTVL
      TCP_LINGER2
      TCP_MD5SIG
      TCP_QUICKACK
      TCP_SYNCNT
      TCP_WINDOW_CLAMP
      TCP_FASTOPEN
      TCP_CONGESTION
      TCP_COOKIE_TRANSACTIONS
      TCP_QUEUE_SEQ
      TCP_REPAIR
      TCP_REPAIR_OPTIONS
      TCP_REPAIR_QUEUE
      TCP_THIN_DUPACK
      TCP_THIN_LINEAR_TIMEOUTS
      TCP_TIMESTAMP
      TCP_USER_TIMEOUT
    ].each {|c| cg.const c, "%lu", "(unsigned long)"}
  end
end
