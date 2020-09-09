require_relative '../../gen/ConstGenerator'
def gen_sock_java(options)
  ConstGenerator.new 'platform.sock', options do |cg|
    cg.include IS_WINDOWS ? "Winsock2.h" : "sys/socket.h"
    %w[
      SOCK_STREAM
      SOCK_DGRAM
      SOCK_RAW
      SOCK_RDM
      SOCK_SEQPACKET
      SOCK_MAXADDRLEN
    ].each {|c| cg.const c}
  end
end
