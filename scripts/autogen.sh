#!/bin/bash

set -e

ARCHS=(
x86_64
aarch64
mips64el
ppc64le
s390x
)


regen_arch(){
    docker run -v $(pwd):$(pwd) merore/jnr-multiarch-env:$1 \
	    /bin/bash -c "cd $(pwd) && rake regen:lplatform"
}

regen_all_arch(){
    for arch in ${ARCHS[@]}; do
        regen_arch $arch
    done
}

if [ $# == 0 ]
then
    regen_all_arch
elif [[ $# == 1 && ${ARCHS[@]/$1/} != ${ARCH[@]} ]]
then
	regen_arch $1
else
	echo ''
	echo './scripts/autogen.sh		regenerate all platform constants'
	echo './scriptes/autogen.sh $ARCH	regenerate constants for the specified platform'
	echo ""
fi
