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
            source py27/bin/activate
            ${args}
        """)
    if [ $res != 0 ]; then
        echo "Failed to create virtualenv"
        return $res
    fi

    // run the command
    res = sh """${args}"""
    return res
}
