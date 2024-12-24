SUMMARY = "Qt test app"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

DEPENDS += "qtbase"

inherit qt6-qmake

SRCREV = "acf035f67299016516d927ef640725a003498aba"
SRC_URI = "git://github.com/scottellis/tspress.git;protocol=https;branch=master"

S = "${UNPACKDIR}/git"

require recipes-qt/qt6/qt6.inc

do_install() {
    install -d ${D}${bindir}
    install -m 0755 ${B}/tspress ${D}${bindir}
}

FILES_${PN} = "${bindir}"

RDEPENDS:${PN} = "qtbase-plugins"
