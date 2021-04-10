def call() {
	sh '''
		adb -s ${IPADDRESS}:${PORT} shell "mkdir -p /data/myci-apc/"
		adb -s ${IPADDRESS}:${PORT} push tools/battery_stats.sh /data/myci-apc/
	'''
}
