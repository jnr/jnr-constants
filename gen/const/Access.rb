require_relative '../../gen/ConstGenerator'
def gen_access_java(options)
  ConstGenerator.new 'platform.access', options do |cg|
    cg.include "unistd.h"
    cg.type = :bitmask
    cg.min_value = 0
    %w[
      F_OK
      X_OK
      W_OK
      R_OK
    ].each { |c| cg.const c }
  end
end
