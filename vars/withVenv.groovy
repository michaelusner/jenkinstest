#!groovy

def call(name='py27', args) {
    if (isUnix()) {
        return venv.withUnix(name, args)
    } else {
        return venv.withWindows(name, args)
    }
}

