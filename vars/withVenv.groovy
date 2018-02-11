#!groovy

def call(name, args) {
    if (isUnix()) {
        return venv.withUnix(name, args)
    } else {
        return venv.withWindows(name, args)
    }
}

