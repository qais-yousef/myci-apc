def call() {
	node('master') {
		cleanWs()
		sh 'cp ../../../tools/* .'
		sh 'ls'
		sh 'pwd'
		stash includes: '*', name: 'tools'
	}
	unstash 'tools'
	sh '''
	adb -s ${IPADDRESS}:${PORT} shell "mkdir -p /data/myci-apc/"
	adb -s ${IPADDRESS}:${PORT} push battery_stats.sh /data/myci-apc/
	'''
}
