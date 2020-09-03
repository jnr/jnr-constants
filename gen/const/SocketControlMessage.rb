require_relative '../../gen/ConstGenerator'
def gen_socketcontrolmessage_java(options)
  ConstGenerator.new 'platform.socket_control_message', options do |cg|
    cg.include "sys/socket.h"
    cg.define _GNU_SOURCE: 1
    %w[
      SCM_RIGHTS
      SCM_TIMESTAMP
      SCM_TIMESTAMPNS
      SCM_TIMESTAMPING
      SCM_BINTIME
      SCM_CREDENTIALS
      SCM_CREDS
      SCM_UCRED
      SCM_WIFI_STATUS
    ].each {|c| cg.const c }
  end
end
    
