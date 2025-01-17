SUMMARY = "A custom console image for the beaglebone boards"

IMAGE_FEATURES += "package-management"
IMAGE_LINGUAS = "en-us"

inherit image

CORE_OS = " \
    openssh openssh-keygen openssh-sftp-server \
    packagegroup-core-boot \
    tzdata \
"

EXTRA_TOOLS = " \
    bzip2 \
    coreutils \
    curl \
    diffutils \
    dosfstools \
    e2fsprogs-mke2fs \
    ethtool \
    file \
    findutils \
    grep \
    i2c-tools \
    iperf3 \
    iproute2-ifstat iproute2-ip iproute2-nstat iproute2-ss \
    iptables \
    less \
    lsof \
    ltrace \
    mtd-utils \
    netcat-openbsd \
    parted \
    procps \
    strace \
    sysfsutils \
    systemd-analyze \
    tar \
    tcpdump \
    util-linux \
    util-linux-blkid \
    unzip \
    wget \
    wireguard-tools \
    zip \
"

IMAGE_INSTALL += " \
    ${CORE_OS} \
    ${EXTRA_TOOLS} \
"

set_local_timezone() {
    ln -sf /usr/share/zoneinfo/EST5EDT ${IMAGE_ROOTFS}/etc/localtime
    echo 'America/New_York' > ${IMAGE_ROOTFS}/etc/timezone
}

ROOTFS_POSTPROCESS_COMMAND += " \
    set_local_timezone ; \
"

export IMAGE_BASENAME = "console-image"
