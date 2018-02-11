package musner

class VirtualEnv {
    String  name

    VirtualEnv(name) { 
        this.name = name
        println("Created new virtualenv ${name}")
    }
}

def isWindows() {
    return System.properties['os.name'].toLowerCase().contains('windows')
}
