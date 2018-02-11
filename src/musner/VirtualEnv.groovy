package musner

class VirtualEnv implements Serializable {
    String  name

    VirtualEnv(name) { 
        this.name = name
        println("Created new virtualenv ${name}")
    }
}
