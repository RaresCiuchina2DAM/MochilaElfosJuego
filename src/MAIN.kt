
fun main() {
    val personajePropio = Jugador("", "", 0, 0, "", "")

    println("VAMOS A CREAR UN PERSONAJE Y A INTERACTUAR CON EL")
    println("Ponle el nombre")
    personajePropio.nombre = readln()

    println("Dime la capacidad de la mochila")
    personajePropio.capacidadPesoMochilaMax = readln().toDouble()

    println("Dime la edad del personaje")
    personajePropio.estadoVital = readln().toInt()

    do {
        println("Dime la raza de tu jugador:")
        println("    Elfo\n    Humano\n    Enano\n    Goblin")
        personajePropio.razas = readln()
    } while (!(personajePropio.razas.equals("elfo", ignoreCase = true))
        && !(personajePropio.razas.equals("Humano", ignoreCase = true))
        && !(personajePropio.razas.equals("Enano", ignoreCase = true))
        && !(personajePropio.razas.equals("Goblin", ignoreCase = true))
    )


    do {
        println("Dime la clase de tu jugador:")
        println("    Mago\n    Ladron\n    Guerrero\n    Berserker")
        personajePropio.oficio = readln()
    } while (!(personajePropio.oficio.equals("Mago", ignoreCase = true))
        && !(personajePropio.oficio.equals("Ladron", ignoreCase = true))
        && !(personajePropio.oficio.equals("Guerrero", ignoreCase = true))
        && !(personajePropio.oficio.equals("Berserker", ignoreCase = true))
    )


    println(personajePropio.toString())
    var respuesta = ""
    while (respuesta != "*") {
        println("Hablemos con el jugador, para parar pulsa '*'")
        respuesta = readln().toString()
        println(hablarConJugador(respuesta, personajePropio))
    }


}