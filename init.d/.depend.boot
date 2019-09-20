TARGETS = console-setup alsa-utils mountkernfs.sh ufw pppd-dns dns-clean plymouth-log x11-common apparmor hostname.sh udev keyboard-setup resolvconf mountdevsubfs.sh brltty procps hwclock.sh checkroot.sh checkfs.sh urandom checkroot-bootclean.sh kmod networking mountall.sh mountall-bootclean.sh mountnfs.sh mountnfs-bootclean.sh bootmisc.sh rc.local
INTERACTIVE = console-setup udev keyboard-setup checkroot.sh checkfs.sh
udev: mountkernfs.sh
keyboard-setup: mountkernfs.sh udev
resolvconf: dns-clean
mountdevsubfs.sh: mountkernfs.sh udev
brltty: mountkernfs.sh udev
procps: mountkernfs.sh udev
hwclock.sh: mountdevsubfs.sh
checkroot.sh: hwclock.sh keyboard-setup mountdevsubfs.sh hostname.sh
checkfs.sh: checkroot.sh
urandom: hwclock.sh
checkroot-bootclean.sh: checkroot.sh
kmod: checkroot.sh
networking: resolvconf mountkernfs.sh urandom dns-clean procps
mountall.sh: checkfs.sh checkroot-bootclean.sh
mountall-bootclean.sh: mountall.sh
mountnfs.sh: networking
mountnfs-bootclean.sh: mountnfs.sh
bootmisc.sh: mountall-bootclean.sh checkroot-bootclean.sh mountnfs-bootclean.sh udev
rc.local: udev keyboard-setup console-setup postgresql networking hwclock.sh rsyslog unattended-upgrades cups-browsed thermald bluetooth dbus open-vm-tools urandom apache2 lightdm resolvconf speech-dispatcher alsa-utils avahi-daemon irqbalance mountdevsubfs.sh checkroot.sh mountkernfs.sh uuidd kerneloops saned whoopsie ufw cups rsync acpid apport cron ssh anacron sysstat pppd-dns mountall-bootclean.sh mountall.sh bootmisc.sh brltty dns-clean checkroot-bootclean.sh mountnfs-bootclean.sh mountnfs.sh plymouth-log kmod procps checkfs.sh x11-common apparmor hostname.sh
