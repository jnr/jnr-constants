require_relative '../../gen/ConstGenerator'
def gen_posixfadvise_java(options)
  ConstGenerator.new 'platform.posix_fadvise', options do |cg|
    cg.include "fcntl.h"
    %w[
      POSIX_FADV_NORMAL
      POSIX_FADV_SEQUENTIAL
      POSIX_FADV_RANDOM
      POSIX_FADV_NOREUSE
      POSIX_FADV_WILLNEED
      POSIX_FADV_DONTNEED
    ].each {|c| cg.const c}
  end
end
