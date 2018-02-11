def call(args) {
    if (isUnix()) {
        return callUnix(args)
    }
}

def callLinux(args) {
    // see if virtualenv is installed
    res = sh(returnStatus: true,
        script: """
            if ! pip freeze | grep virtualenv; then
                python2 -m pip install virtualenv
            fi
        """
    )
    if (res != 0) {
        error("Failed to install virtualenv")
    }

    // create the env if it doesn't exist
    res = sh(returnStatus: true,
        script: """
            if [ ! -d "py27" ]; then
                python2 -m virtualenv py27           
            fi
            . ./py27/bin/activate
            ${args}
        """
    )
    println "result: ${res}"
    if (res != 0) {
        error("Failed to run command")
    }
    return res
}
