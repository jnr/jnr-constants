require_relative '../../gen/ConstGenerator'
def gen_rlimit_java(options)
  ConstGenerator.new 'platform.rlimit', options do |cg|
    cg.include "stdint.h"
    cg.include "sys/resource.h"
    cg.include "sys/types.h"
    %w[
      RLIMIT_AS
      RLIMIT_CORE
      RLIMIT_CPU
      RLIMIT_DATA
      RLIMIT_FSIZE
      RLIMIT_LOCKS
      RLIMIT_MEMLOCK
      RLIMIT_MSGQUEUE
      RLIMIT_NICE
      RLIMIT_NLIMITS
      RLIMIT_NOFILE
      RLIMIT_NPROC
      RLIMIT_OFILE
      RLIMIT_RSS
      RLIMIT_RTPRIO
      RLIMIT_RTTIME
      RLIMIT_SIGPENDING
      RLIMIT_STACK
    ].each {|c| cg.const c }
  end
end
