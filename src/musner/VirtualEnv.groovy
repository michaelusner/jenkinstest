package musner

class VirtualEnv {
    String  name

    VirtualEnv(name) { 
        this.name = name
        if (!this.isWindows()) {
            def sout = new StringBuilder(), serr = new StringBuilder()
            def proc = 'virtualenv ${name}'.execute()
            proc.consumeProcessOutput(sout, serr)
            proc.waitForOrKill(1000)
            println "out> $sout err> $serr"
            println("Created new virtualenv ${name}")
        }
    }

    def isWindows() {
        return System.properties['os.name'].toLowerCase().contains('windows')
    }
}
