require_relative '../../gen/ConstGenerator'
def gen_socketlevel_java(options)
  ConstGenerator.new 'platform.socketlevel', options do |cg|
    cg.include "sys/socket.h"
    %w[
      SOL_SOCKET
      SOL_IP
      SOL_TCP
      SOL_UDP
    ].each {|c| cg.const c}
  end
end
