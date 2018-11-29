require_relative '../../gen/ConstGenerator'
# Offending defines:
#      TCGETS2
#      TCSETS2
#      TCSETSW2
#      TCSETSF2 
#      TIOCGPTN
#      TIOCSPTLCK
#      TIOCGDEV
#      TIOCSIG
#      TIOCGPKT
#      TIOCGPTLCK
#      TIOCGEXCL

def gen_ioctlflags_java(options)
  ConstGenerator.new 'platform.ioctlflags', options do |cg|
    cg.include "sys/ioctl.h"
    %w[
      TCGETS
      TCSETS
      TCSETSW
      TCSETSF
      TCGETA
      TCSETA
      TCSETAW
      TCSETAF
      TCSBRK
      TCXONC
      TCFLSH
      TIOCEXCL
      TIOCNXCL
      TIOCSCTTY
      TIOCGPGRP
      TIOCSPGRP
      TIOCOUTQ
      TIOCSTI
      TIOCGWINSZ
      TIOCSWINSZ
      TIOCMGET
      TIOCMBIS
      TIOCMBIC
      TIOCMSET
      TIOCGSOFTCAR
      TIOCSSOFTCAR
      FIONREAD
      TIOCINQ
      TIOCLINUX
      TIOCCONS
      TIOCGSERIAL
      TIOCSSERIAL
      TIOCPKT
      FIONBIO
      TIOCNOTTY
      TIOCSETD
      TIOCGETD
      TCSBRKP
      TIOCSBRK
      TIOCCBRK
      TIOCGSID
      TIOCGRS485
      TIOCSRS485
      TCGETX
      TCSETX
      TCSETXF
      TCSETXW
      TIOCVHANGUP
      TIOCGPTPEER
      FIONCLEX
      FIOCLEX
      FIOASYNC
      TIOCSERCONFIG
      TIOCSERGWILD
      TIOCSERSWILD
      TIOCGLCKTRMIOS
      TIOCSLCKTRMIOS
      TIOCSERGSTRUCT
      TIOCSERGETLSR
      TIOCSERGETMULTI
      TIOCSERSETMULTI
      TIOCMIWAIT
      TIOCGICOUNT
      FIOQSIZE
      TIOCPKT_DATA
      TIOCPKT_FLUSHREAD
      TIOCPKT_FLUSHWRITE
      TIOCPKT_STOP
      TIOCPKT_START
      TIOCPKT_NOSTOP
      TIOCPKT_DOSTOP
      TIOCPKT_IOCTL
      TIOCSER_TEMT
      TIOCM_CTS
      TIOCM_CAR
      TIOCM_DSR
      TIOCM_RNG
      TIOCM_DTR
      TIOCM_RTS].each { |c| cg.const c }
  end
end
