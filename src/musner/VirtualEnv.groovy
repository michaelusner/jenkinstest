package musner

class VirtualEnv {
    String  name

    VirtualEnv(name) { 
        this.name = name
        println("Created new virtualenv ${name}")
    }
}
