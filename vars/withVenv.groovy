def call(args) {
    // see if pip is installed
    sh(script: """
        if ! which pip; then
            easy_install pip
        fi
    """)

    // see if virtualenv is installed
    sh(script: """
        if ! pip freeze | grep virtualenv; then
            python2 -m pip install virtualenv
        fi
    """)

    // run the command
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
