def call() {
	dev_shell("mkdir -p /data/myci-apc/")
	dev_shell("rm -rf /data/myci-apc/*")
	dev_push("tools/battery_stats.sh", "/data/myci-apc")
}
