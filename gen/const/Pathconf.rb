require_relative '../../gen/ConstGenerator'
def gen_pathconf_java(options)
  ConstGenerator.new 'platform.pathconf', options do |cg|
    cg.include "sys/types.h"
    cg.include "unistd.h"
    %w[
      _PC_FILESIZEBITS
      _PC_LINK_MAX
      _PC_MAX_CANON
      _PC_MAX_INPUT
      _PC_NAME_MAX
      _PC_PATH_MAX
      _PC_PIPE_BUF
      _PC_2_SYMLINKS
      _PC_ALLOC_SIZE_MIN
      _PC_REC_INCR_XFER_SIZE
      _PC_REC_MAX_XFER_SIZE
      _PC_REC_MIN_XFER_SIZE
      _PC_REC_XFER_ALIGN
      _PC_SYMLINK_MAX
      _PC_CHOWN_RESTRICTED
      _PC_NO_TRUNC
      _PC_VDISABLE
      _PC_ASYNC_IO
      _PC_PRIO_IO
      _PC_SYNC_IO
    ].each {|c| cg.const(c) }
  end
end
