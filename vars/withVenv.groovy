def call(args) {
    sh(
        returnStdout: true,
        script: """
            if [ ! -d "py27" ]; then
                python2 -m virtualenv py27           
            fi
            source py27/bin/activate
            ${args}
        """
    )
}
