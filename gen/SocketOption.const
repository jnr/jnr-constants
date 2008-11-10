require 'gen/ConstGenerator'
def gen_socketoption_java(options)
  ConstGenerator.new 'platform.socket_option', options do |cg|
    cg.include "sys/socket.h"
    cg.const %w[
      SO_DEBUG
      SO_ACCEPTCONN
      SO_REUSEADDR
      SO_KEEPALIVE
      SO_DONTROUTE
      SO_BROADCAST
      SO_USELOOPBACK
      SO_LINGER
      SO_OOBINLINE
      SO_REUSEPORT
      SO_TIMESTAMP
      SO_ACCEPTFILTER
      SO_DONTTRUNC
      SO_WANTMORE
      SO_WANTOOBFLAG
      SO_SNDBUF
      SO_RCVBUF
      SO_SNDLOWAT
      SO_RCVLOWAT
      SO_SNDTIMEO
      SO_RCVTIMEO
      SO_ERROR
      SO_TYPE
      SO_NREAD
      SO_NKE
      SO_NOSIGPIPE
      SO_NOADDRERR
      SO_NWRITE
      SO_REUSESHAREUID
      SO_LABEL
      SO_PEERLABEL
    ]
  end
end
    