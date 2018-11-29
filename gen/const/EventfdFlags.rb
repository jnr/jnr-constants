require_relative '../../gen/ConstGenerator'
def gen_eventfdflags_java(options)
  ConstGenerator.new 'platform.eventfdflags', options do |cg|
    cg.include "sys/eventfd.h"
    %w[EFD_CLOEXEC
    EFD_NONBLOCK
    EFD_SEMAPHORE].each { |c| cg.const c }
  end
end
