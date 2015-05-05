require_relative '../../gen/ConstGenerator'
def gen_access_java(options)
  ConstGenerator.new 'platform.access', options do |cg|
    cg.include "unistd.h"
    cg.type = :bitmask
    %w[
      F_OK
      R_OK
      W_OK
      X_OK
    ].each { |c| cg.const c }
  end
end
