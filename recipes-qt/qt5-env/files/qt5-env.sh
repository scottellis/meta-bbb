#!/bin/sh

export PATH=${PATH}:/usr/bin/qt5

export QT_QPA_PLATFORM=linuxfb

# to use tslib for input (no multi-touch)
# don't appear to need this with the latest qt
#export QT_QPA_FB_TSLIB=1

# replace with correct /dev/input/eventX if this is wrong
# don't appear to need this with the latest qt
#export TSLIB_TSDEVICE=/dev/input/touchscreen0

if [ -z "${XDG_RUNTIME_DIR}" ]; then
    export XDG_RUNTIME_DIR=/tmp/user/${UID}

    if [ ! -d ${XDG_RUNTIME_DIR} ]; then
        mkdir -p ${XDG_RUNTIME_DIR}
	chmod 0700 ${XDG_RUNTIME_DIR}
    fi
fi
