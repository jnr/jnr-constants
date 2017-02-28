require_relative '../../gen/ConstGenerator'
def gen_locale_java(options)
  ConstGenerator.new 'platform.locale', options do |cg|
    cg.include "locale.h"
    cg.min_value = 0
    consts = %w[
      LC_CTYPE
      LC_NUMERIC
      LC_TIME
      LC_COLLATE
      LC_MONETARY
      LC_MESSAGES
      LC_ALL
      LC_PAPER
      LC_NAME
      LC_ADDRESS
      LC_TELEPHONE
      LC_MEASUREMENT
      LC_IDENTIFICATION
    ]
    consts.each { |c| cg.const c }
  end
end
