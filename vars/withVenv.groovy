def call(args) {
        // see if virtualenv is installed
    sh(script: """
        if ! pip freeze | grep virtualenv; then
            python2 -m pip install virtualenv
        fi
    """)

    // create the env if it doesn't exist
    res = sh(script: """
            if [ ! -d "py27" ]; then
                python2 -m virtualenv py27           
            fi
            . ./py27/bin/activate
            ${args}
        """)
    if ($res != 0) {
        println "Failed to run command"
        return $res
    }
}
