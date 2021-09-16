require_relative '../../gen/ConstGenerator'
def gen_syslog_java(options)
  ConstGenerator.new 'platform.syslog', options do |cg|
    cg.include "syslog.h"
    %w[
      LOG_ALERT
      LOG_AUTH
      LOG_AUTHPRIV
      LOG_CONS
      LOG_CONSOLE
      LOG_CRIT
      LOG_CRON
      LOG_DAEMON
      LOG_DEBUG
      LOG_EMERG
      LOG_ERR
      LOG_FTP
      LOG_INFO
      LOG_KERN
      LOG_LOCAL0
      LOG_LOCAL1
      LOG_LOCAL2
      LOG_LOCAL3
      LOG_LOCAL4
      LOG_LOCAL5
      LOG_LOCAL6
      LOG_LOCAL7
      LOG_LPR
      LOG_MAIL
      LOG_NDELAY
      LOG_NEWS
      LOG_NOTICE
      LOG_NOWAIT
      LOG_NTP
      LOG_ODELAY
      LOG_PERROR
      LOG_PID
      LOG_SECURITY
      LOG_SYSLOG
      LOG_USER
      LOG_UUCP
      LOG_WARNING
    ].each {|c| cg.const c}
  end
end
