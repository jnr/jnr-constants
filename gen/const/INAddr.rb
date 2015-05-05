require_relative '../../gen/ConstGenerator'
def gen_inaddr_java(options)
  ConstGenerator.new 'platform.inaddr', options do |cg|
    cg.include "sys/types.h"
    cg.include "netinet/in.h"
    %w[
      INADDR_ANY
      INADDR_BROADCAST
      INADDR_NONE
      INADDR_LOOPBACK
      INADDR_UNSPEC_GROUP
      INADDR_ALLHOSTS_GROUP
      INADDR_ALLRTRS_GROUP
      INADDR_MAX_LOCAL_GROUP
    ].each {|c| cg.const(c, "%#x", "(unsigned int)") { |v| v.hex} }
  end
end
