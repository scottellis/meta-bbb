require linux-stable.inc

KERNEL_CONFIG_COMMAND = "oe_runmake_call -C ${S} CC="${KERNEL_CC}" O=${B} olddefconfig"

COMPATIBLE_MACHINE = "beaglebone"

KERNEL_DEVICETREE ?= " \
    ti/omap/am335x-boneblack.dtb \
    ti/omap/am335x-boneblack-wireless.dtb \
    ti/omap/am335x-boneblue.dtb \
    ti/omap/am335x-bonegreen.dtb \
    ti/omap/am335x-bonegreen-wireless.dtb \
    ti/omap/am335x-pocketbeagle.dtb \
    ti/omap/bbb-gen4-4dcape70t.dtb \
"

LINUX_VERSION = "6.11"

FILESEXTRAPATHS:prepend := "${THISDIR}/linux-stable-${LINUX_VERSION}:${THISDIR}/linux-stable-${LINUX_VERSION}/dts:"

S = "${WORKDIR}/git"

PV = "6.11.8"
SRCREV = "f0c5b21ac4e630f35b9a29268a0f712501d4ffac"
SRC_URI = " \
    git://git.kernel.org/pub/scm/linux/kernel/git/stable/linux-stable.git;branch=linux-${LINUX_VERSION}.y \
    file://defconfig \
    file://0001-kbuild-remove-dependency-on-truncate.patch \
    file://0002-Remove-i2c2-cape-dts-config.patch \
    file://bbb-gen4-4dcape70t.dts \
"

do_configure:prepend() {
    cp ${WORKDIR}/*.dts ${S}/arch/arm/boot/dts/ti/omap
}