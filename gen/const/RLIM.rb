require_relative '../../gen/ConstGenerator'
def gen_rlim_java(options)
  ConstGenerator.new 'platform.rlimit', options do |cg|
    cg.include "stdint.h"
    cg.include "sys/resource.h"
    cg.include "sys/types.h"
    %w[
      RLIM_NLIMITS
      RLIM_INFINITY
      RLIM_SAVED_MAX
      RLIM_SAVED_CUR
    ].each {|c| cg.const(c, "%#lx", "(unsigned long)") { |v| v.hex} }
  end
end
