require_relative '../../gen/ConstGenerator'
def gen_inet_java(options)
  ConstGenerator.new 'platform.inet', options do |cg|
    cg.include IS_WINDOWS ? "Ws2tcpip.h" : "netinet/in.h"
    %w[
      INET_ADDRSTRLEN
    ].each {|c| cg.const c, "%lu", "(unsigned long)"}
  end
end
