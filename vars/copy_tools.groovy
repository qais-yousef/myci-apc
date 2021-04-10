def call() {
	sh '''
		adb -s ${IPADDRESS}:${PORT} shell "mkdir -p /data/myci-apc/"
	'''
	dev_push("tools/battery_stats.sh", "/data/myci-apc")
}
