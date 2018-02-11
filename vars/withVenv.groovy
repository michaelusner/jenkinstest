#!groovy

def call(body) {
    if (isUnix()) {
        return venv.withUnix(body.name, body.args)
    } else {
        return venv.withWindows(body.name, body.args)
    }
}

