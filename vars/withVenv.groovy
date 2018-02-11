#!groovy

def call(String name='py27', String args) {
    if (isUnix()) {
        return venv.withUnix(name, args)
    } else {
        return venv.withWindows(name, args)
    }
}

