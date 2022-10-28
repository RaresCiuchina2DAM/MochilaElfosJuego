import java.lang.Thread.sleep

fun main() {
    var personaje = Jugador("Juan", 25, "Humano", "Ladron")
    var personajePrincipal = Jugador("", 25, "", "")
    var personaje2 = Jugador("", 25, "Humano", "Mago")
    var objeto1 = Objeto(1,8,30)
    var objeto2 = Objeto(2, 5, 20)
    var objeto3 = Objeto(3,2,12)
    var objeto4 = Objeto(4,5,38)
    var objeto5 = Objeto(5,20,350)
    val listaObjetos = mutableListOf<Objeto>(objeto1, objeto2, objeto3, objeto4, objeto5)

    println("Bienvenido a la tienda de objetos de la ciudad de Puerta del Sol")
    personaje = definirPersonaje(personaje)
    println("El jugador ${personaje.nombre} es un ${personaje.razas} de ${personaje.estadoVital} años de edad y es un ${personaje.clase}")
    println("Vamos a definir al otro jugador")
    personaje2 = definirPersonaje(personaje2)
    println("El jugador ${personaje2.nombre} es un ${personaje2.razas} de ${personaje2.estadoVital} años de edad y es un ${personaje2.clase}")


//
    while (personaje.nombre == personaje2.nombre) {
        println("Los jugadores no pueden tener el mismo nombre, por favor, introduzca otro nombre para el segundo personaje")
        personaje2.nombre = readLine()!!
    }



    if (esMercader(personaje) && (!(esMercader(personaje2)))) {
        println("TU jugador PRINCIPAL será ${personaje2.nombre} y el jugador con el que interactuarás será ${personaje2.nombre}")
         personajePrincipal = personaje2
    } else if (esMercader(personaje2) && (!(esMercader(personaje)))) {

        println("TU jugador PRINCIPAL será ${personaje.nombre} y el jugador con el que interactuarás será ${personaje.nombre}")
         personajePrincipal = personaje
    }




    if (personajePrincipal.clase.lowercase() == "Ladron".lowercase()){
        println("El jugador ${personajePrincipal.nombre} es un ${personajePrincipal.clase} y por lo tanto puede robar")
        println("*procede a robar*")
        robar(personajePrincipal, listaObjetos)
        sleep(200)
        println("La lista de objetos que ha conseguido es: ${personajePrincipal.toStringInventario()}")
    } else {
        println("El jugador ${personajePrincipal.nombre} es un ${personajePrincipal.clase} y por lo tanto no puede robar")
    }

    println("¿Que quieres hacer?")
    println("1. vender")
    println("2. hablar")


}
fun esMercader(personaje :Jugador): Boolean {
    return personaje.clase.lowercase() == "Mercader".lowercase()
}

fun definirPersonaje (personaje: Jugador) : Jugador {
    setNombre(personaje)
    println("¿Cuántos años quieres que tenga el jugador: ${personaje.nombre}?")
    personaje.estadoVital = readLine()!!.toInt()
    setClase(personaje)
    setRaza(personaje)

    return personaje
}

fun setClase(personaje: Jugador): Jugador {
    do {
        println("¿Cual es la clase que quieres que tenga el jugador: ${personaje.nombre}")
        personaje.clase = readLine()!!
    } while ((personaje.clase.lowercase() != "Guerrero".lowercase())
        && (personaje.clase.lowercase() != "Mago".lowercase())
        && (personaje.clase.lowercase() != "Ladron".lowercase())
        && (personaje.clase.lowercase() != "Berserker".lowercase())
        && (personaje.clase.lowercase() != "Mercader".lowercase())
    )
    return personaje
}
fun setRaza(personaje: Jugador): Jugador {
    do {
        println("¿Cual es la raza que quieres que tenga el jugador: ${personaje.nombre}?")
        personaje.razas = readLine()!!
    } while (personaje.razas.lowercase() != "Humano".lowercase()
        && personaje.razas.lowercase() != "Elfo".lowercase()
        && personaje.razas.lowercase() != "Enano".lowercase()
        && personaje.razas.lowercase() != "Goblin".lowercase()
    )
    return personaje
}

fun setNombre(personaje: Jugador): Jugador {
        println("¿Cual es el nombre que quieres que tenga el jugador: ${personaje.nombre}?")
        personaje.nombre = readLine()!!

    return personaje
}



