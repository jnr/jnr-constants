require_relative '../../gen/ConstGenerator'
def gen_local_java(options)
  ConstGenerator.new 'platform.local', options do |cg|
    cg.include "sys/types.h"
    cg.include "sys/un.h"
    consts = %w[
      LOCAL_PEERCRED
      LOCAL_CREDS
      LOCAL_CONNWAIT
    ]
    consts.each { |c| cg.const c }
  end
end
