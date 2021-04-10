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
	adb shell "mkdir -p /data/myci-apc/"
	adb push battery_stats.sh /data/myci-apc/
	'''
}
