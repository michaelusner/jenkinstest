#!groovy

def call(params) {
    if (isUnix()) {
        return venv.withUnix(params.name, params.args)
    } else {
        return venv.withWindows(params.name, params.args)
    }
}

