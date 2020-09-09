require_relative '../../gen/ConstGenerator'
def gen_multicast_java(options)
  ConstGenerator.new 'platform.multicast', options do |cg|
    cg.include "netinet/in.h"
    %w[
      MCAST_JOIN_GROUP
      MCAST_BLOCK_SOURCE
      MCAST_UNBLOCK_SOURCE
      MCAST_LEAVE_GROUP
      MCAST_JOIN_SOURCE_GROUP
      MCAST_LEAVE_SOURCE_GROUP
      MCAST_MSFILTER
      MCAST_EXCLUDE
      MCAST_INCLUDE
    ].each {|c| cg.const c, "%lu", "(unsigned long)"}
  end
end
