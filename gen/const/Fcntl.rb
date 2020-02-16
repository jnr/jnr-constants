require_relative '../../gen/ConstGenerator'
def gen_fcntl_java(options)
  ConstGenerator.new 'platform.fcntl', options do |cg|
    cg.include "fcntl.h"
    cg.include "string.h"
    cg.define _GNU_SOURCE: 1
    cg.min_value = 0
    cg.unknown_range=[20000, 20999]
    consts = %w[
      FAPPEND
      FREAD
      FWRITE
      FASYNC
      FFSYNC
      FNONBLOCK
      FNDELAY
      F_DUPFD
      F_GETFD
      F_SETFD
      F_GETFL
      F_SETFL
      F_GETOWN
      F_SETOWN
      F_GETLK
      F_SETLK
      F_SETLKW
      F_CHKCLEAN
      F_PREALLOCATE
      F_SETSIZE
      F_RDADVISE
      F_RDAHEAD
      F_READBOOTSTRAP
      F_WRITEBOOTSTRAP
      F_NOCACHE
      F_LOG2PHYS
      F_GETPATH
      F_FULLFSYNC
      F_PATHPKG_CHECK
      F_FREEZE_FS
      F_THAW_FS
      F_GLOBAL_NOCACHE
      F_ADDSIGS
      F_MARKDEPENDENCY
      F_RDLCK
      F_UNLCK
      F_WRLCK
      F_ALLOCATECONTIG
      F_ALLOCATEALL
      F_GETPIPE_SZ
      F_SETPIPE_SZ
    ]
    consts.each { |c| cg.const c }
  end
end
