require 'gen/ConstGenerator'
def gen_waitflags_java(options)
  ConstGenerator.new 'platform.waitflags', options do |cg|
    cg.include "sys/wait.h"
    %w[
WNOHANG
WUNTRACED
WSTOPPED
WEXITED
WCONTINUED
WNOWAIT
    ].each {|c| cg.const(c, "%#x", "(unsigned int)") { |v| v.hex} }
  end
end
