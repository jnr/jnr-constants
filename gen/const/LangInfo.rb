require_relative '../../gen/ConstGenerator'
def gen_langinfo_java(options)
  ConstGenerator.new 'platform.langinfo', options do |cg|
    cg.include "langinfo.h"
    %w[
      CODESET
      D_T_FMT
      D_FMT
      T_FMT
      DAY_1
      DAY_2
      DAY_3
      DAY_4
      DAY_5
      DAY_6
      DAY_7
      ABDAY_1
      ABDAY_2
      ABDAY_3
      ABDAY_4
      ABDAY_5
      ABDAY_6
      ABDAY_7
      MON_1
      MON_2
      MON_3
      MON_4
      MON_5
      MON_6
      MON_7
      MON_8
      MON_9
      MON_10
      MON_11
      MON_12
      ABMON_1
      ABMON_2
      ABMON_3
      ABMON_4
      ABMON_5
      ABMON_6
      ABMON_7
      ABMON_8
      ABMON_9
      ABMON_10
      ABMON_11
      ABMON_12
      RADIXCHAR
      THOUSEP
      YESEXPR
      NOEXPR
      CRNCYSTR
    ].each {|c| cg.const c}
  end
end
