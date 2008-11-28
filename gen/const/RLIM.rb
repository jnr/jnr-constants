require 'gen/ConstGenerator'
def gen_rlim_java(options)
  ConstGenerator.new 'platform.rlimit', options do |cg|
    cg.include "sys/resource.h"
    %w[
      RLIM_NLIMITS
      RLIM_INFINITY
      RLIM_SAVED_MAX
      RLIM_SAVED_CUR
    ].each {|c| cg.const(c, "%#lx", "(unsigned long)") { |v| v.hex} }
  end
end