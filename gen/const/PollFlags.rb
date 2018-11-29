require_relative '../../gen/ConstGenerator'
def gen_pollflags_java(options)
  ConstGenerator.new 'platform.pollflags', options do |cg|
    cg.include "poll.h"
    %w[POLLERR
    POLLHUP
    POLLIN
    POLLNVAL
    POLLOUT
    POLLPRI
    POLLRDBAND
    POLLRDNORM
    POLLWRBAND
    POLLWRNORM].each { |c| cg.const c }
  end
end
