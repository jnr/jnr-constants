require_relative '../../gen/ConstGenerator'
def gen_inet6_java(options)
  ConstGenerator.new 'platform.inet6', options do |cg|
    cg.include IS_WINDOWS ? "Ws2tcpip.h" : "netinet/in.h"
    %w[
      INET6_ADDRSTRLEN
    ].each {|c| cg.const c, "%lu", "(unsigned long)"}
  end
end
