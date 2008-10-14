require 'gen/ConstGenerator'
def gen_shutdown_java(options)
  ConstGenerator.new 'platform.shutdown', options do |cg|
    cg.include "sys/socket.h"
    cg.const %w[
      SHUT_RD
      SHUT_WR
      SHUT_RDWR
    ]
  end
end