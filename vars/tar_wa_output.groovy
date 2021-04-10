def call() {
	sh """
		tar cJvf wa_output.tar.xz wa_output
	"""
}
