package Final


fun seleccionarObjeto(personaje: Jugador): Objeto {
    var objetoSeleccionado = Objeto(0,0,0)
    println("¿Que objeto quieres vender?")
    println(personaje.toStringInventario())

    val idObjeto = readLine()!!.toInt()
    do {
        for (i in personaje.inventario.indices) {
            if ( idObjeto == personaje.inventario[i].id ) {
                objetoSeleccionado = personaje.inventario[i]
            }
        }
    } while (objetoSeleccionado.id != idObjeto)
    return objetoSeleccionado

}

fun quieresvenderlo () : String {

    var opcion = ""
    do {
        println("¿Quieres venderlo? (S/N)")
        opcion = readLine()!!.toString()
    } while ((opcion != "S") && (opcion != "N"))
    return opcion
}

fun venderObjeto(personajeVendedor: Jugador, personajeComprador : Jugador, objetoseleccionado: Objeto) {
    println("El objeto ha sido vendido")

    personajeComprador.inventario.add(objetoseleccionado)
    personajeVendedor.inventario.remove(objetoseleccionado)
    if (personajeVendedor.inventario.isEmpty()) {
        println("El ${personajeVendedor.nombre} no tiene mas objetos")
    }else println("El jugador ${personajeVendedor.nombre} tiene ahora en su mochila ${personajeVendedor.toStringInventario()}")

    if (personajeComprador.inventario.isEmpty()) {
        println("El ${personajeComprador.nombre} no tiene mas objetos")
    }else println("El jugador ${personajeComprador.nombre} tiene ahora en su mochila ${personajeComprador.toStringInventario()}")

    println()
    println()

    //Intercanbio de dinero
    println(toStringDinero(objetoseleccionado.valor))
    personajeVendedor.cantidadmonedas = cambioMonedas(objetoseleccionado.valor)
    println("El jugador ${personajeVendedor.nombre} tiene ahora ${toStringDinero(IntArrayToInt(personajeVendedor.cantidadmonedas))}")

}

fun venderXObjetos(personajePrincipal : Jugador, personajeMercader : Jugador ) {
    var objetoseleccionado = Objeto(0,0,0)
    println("Cuantos objetos quieres vender?")
    val numObjetos = readLine()!!.toInt()
    repeat(numObjetos) {
        objetoseleccionado = seleccionarObjeto(personajePrincipal)
        println(
            "Has seleccionado el objeto ${objetoseleccionado.id} con un peso de" +
                    " ${objetoseleccionado.peso} y un valor de ${objetoseleccionado.valor} puermacoins"
        )
        val siono = quieresvenderlo()
        if (siono.uppercase() == "S") {
            venderObjeto(personajePrincipal, personajeMercader, objetoseleccionado)
        } else
            println("El objeto no se venderá")

    }
}

fun quequieresHacer(): Int {
    var opcion = 0
    println("¿Que quieres hacer?")
    println("1. Vender")
    println("2. Hablar")
    do {
        opcion = readLine()!!.toInt()
    } while ((opcion != 1) && (opcion != 2))

    return opcion
}