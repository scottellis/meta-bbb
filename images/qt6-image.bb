SUMMARY = "A Qt6 development image"
HOMEPAGE = "http://www.jumpnowtek.com"

require console-image.bb

QT_DEV_TOOLS = " \
    qtbase-dev \
    qtbase-mkspecs \
    qtbase-tools \
"

QT_TOOLS = " \
    qtbase \
    qtbase-plugins \
    qt6-env \
"

FONTS = " \
    fontconfig \
    fontconfig-utils \
    ttf-bitstream-vera \
"

TSLIB = " \
    tslib \
    tslib-calibrate \
    tslib-conf \
"

IMAGE_INSTALL += " \
    ${FONTS} \
    ${QT_TOOLS} \
    ${TSLIB} \
    tspress-tools \
"

export IMAGE_BASENAME = "qt5-image"
