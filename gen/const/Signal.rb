require_relative '../../gen/ConstGenerator'
require 'rbconfig'
def gen_signal_java(options)
  ConstGenerator.new 'platform.signal', options do |cg|
    cg.include "signal.h"
    cg.include "win32.h" if RbConfig::CONFIG['host_os'] == 'mswin32'
    %w[
SIGHUP
SIGINT
SIGQUIT
SIGILL
SIGTRAP
SIGABRT
SIGIOT
SIGBUS
SIGFPE
SIGKILL
SIGUSR1
SIGSEGV
SIGUSR2
SIGPIPE
SIGALRM
SIGTERM
SIGSTKFLT
SIGCLD
SIGCHLD
SIGCONT
SIGSTOP
SIGTSTP
SIGTTIN
SIGTTOU
SIGURG
SIGXCPU
SIGXFSZ
SIGVTALRM
SIGPROF
SIGWINCH
SIGPOLL
SIGIO
SIGPWR
SIGSYS
SIGUNUSED
SIGRTMIN
SIGRTMAX
NSIG
    ].each {|c| cg.const c}
  end
end
