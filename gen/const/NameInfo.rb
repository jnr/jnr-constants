require_relative '../../gen/ConstGenerator'
def gen_nameinfo_java(options)
  ConstGenerator.new 'platform.nameinfo', options do |cg|
    cg.include "sys/socket.h"
    cg.include "netdb.h"
    %w[
      NI_MAXHOST
      NI_MAXSERV
      NI_NOFQDN
      NI_NUMERICHOST
      NI_NAMEREQD
      NI_NUMERICSERV
      NI_DGRAM
      NI_WITHSCOPEID
    ].each {|c| cg.const c}
  end
end
