import java.lang.Thread.sleep



fun main() {
    var personaje = Jugador("", 25, "Humano", "Ladron")
    var personajePrincipal = Jugador("juan", 25, "Humano", "Ladron")
    var personajeMercader = Jugador("MERCADER", 25, "Humano", "Mercader")
    var personaje2 = Jugador("", 25, "Humano", "Ladron")
    val objeto1 = Objeto(1, 8, 30)
    val objeto2 = Objeto(2, 5, 20)
    val objeto3 = Objeto(3, 2, 12)
    val objeto4 = Objeto(4, 5, 38)
    val objeto5 = Objeto(5, 20, 350)
    val listaObjetos = mutableListOf<Objeto>(objeto1, objeto2, objeto3, objeto4, objeto5)
    var objetoseleccionado = Objeto(0, 0, 0)


    println("Bienvenido a la tienda de objetos de la ciudad de Puerta del Sol")
    personaje = definirPersonaje(personaje)
    println("El jugador ${personaje.nombre} es un ${personaje.razas} de ${personaje.estadoVital} años de edad y es un ${personaje.clase}")
    println("Vamos a definir al otro jugador")
    personaje2 = definirPersonaje(personaje2)
    println("El jugador ${personaje2.nombre} es un ${personaje2.razas} de ${personaje2.estadoVital} años de edad y es un ${personaje2.clase}")
//
//

    while (personaje.nombre == personaje2.nombre) {
        println("Los jugadores no pueden tener el mismo nombre, por favor, introduzca otro nombre para el segundo personaje")
        personaje2.nombre = readLine()!!
    }

    if (esMercader(personaje) && (!(esMercader(personaje2)))) {
        println("TU jugador PRINCIPAL será ${personaje2.nombre} y el jugador con el que interactuarás será ${personaje.nombre}")
        personajePrincipal = personaje2
        personajeMercader = personaje
    } else if (esMercader(personaje2) && (!(esMercader(personaje)))) {
        println("TU jugador PRINCIPAL será ${personaje.nombre} y el jugador con el que interactuarás será ${personaje2.nombre}")
        personajePrincipal = personaje
        personajeMercader = personaje2
    }

    if (personajePrincipal.clase.lowercase() == "Ladron".lowercase()) {
        println("El jugador ${personajePrincipal.nombre} es un ${personajePrincipal.clase} y por lo tanto puede robar")
        println("El jugador ${personajePrincipal.nombre} tiene una mochila con una capacidad de ${personajePrincipal.capacidadPesoMochilaMax} kg")
        println("*procede a robar*")
        personajePrincipal.inventario = robar(personajePrincipal, listaObjetos)
        sleep(3000)
        println("La lista de objetos que ha conseguido es: ${personajePrincipal.toStringInventario()}")

    } else {
        println("El jugador ${personajePrincipal.nombre} es un ${personajePrincipal.clase} y por lo tanto no puede robar")
    }


    println()



    val opcion = quequieresHacer()

    if (opcion == 1) {
        venderXObjetos(personajePrincipal, personajeMercader)

    } else {

        var respuesta = ""
        println("¿Que quieres decirle?")
        respuesta = readLine()!!
        while (respuesta.lowercase() != "Adios".lowercase()) {
            hablarConJugador(respuesta, personajeMercader)
            println("¿Que quieres decirle?")
            respuesta = readLine()!!
        }
    }
}
