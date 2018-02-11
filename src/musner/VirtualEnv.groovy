package musner

class VirtualEnv {
    String  name

    VirtualEnv(name) { 
        this.name = name
        if (!this.isWindows()) {
            
            println("Created new virtualenv ${name}")
        }
    }

    def isWindows() {
        return System.properties['os.name'].toLowerCase().contains('windows')
    }
}

