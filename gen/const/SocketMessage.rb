require_relative '../../gen/ConstGenerator'
def gen_socketmessage_java(options)
  ConstGenerator.new 'platform.socket_message', options do |cg|
    cg.include IS_WINDOWS ? "Winsock2.h" : "sys/socket.h"
    %w[
      MSG_DONTWAIT
      MSG_OOB
      MSG_PEEK
      MSG_DONTROUTE
      MSG_EOR
      MSG_TRUNC
      MSG_CTRUNC
      MSG_WAITALL
      MSG_PROXY
      MSG_FIN
      MSG_SYN
      MSG_CONFIRM
      MSG_RST
      MSG_ERRQUEUE
      MSG_NOSIGNAL
      MSG_MORE
      MSG_FASTOPEN
      MSG_EOF
      MSG_FLUSH
      MSG_HOLD
      MSG_SEND
      MSG_HAVEMORE
      MSG_RCVMORE
      MSG_COMPAT
    ].each {|c| cg.const(c, "%#x", "(unsigned int)") { |v| v.hex} }
  end
end
    
