require_relative '../../gen/ConstGenerator'
def gen_prio_java(options)
  ConstGenerator.new 'platform.prio', options do |cg|
    cg.include "sys/resource.h"
    %w[
      PRIO_MIN
      PRIO_PROCESS
      PRIO_PGRP
      PRIO_USER
      PRIO_MAX
    ].each {|c| cg.const c }
  end
end
