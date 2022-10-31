package Final

class Jugador {
    //Variables
    var sumValor = 0
    var sumPeso = 0
    var nombre = ""
    var capacidadPesoMochilaMax = Dado(0, 0).tiradaUnica() * 10.toDouble()
    var estadoVital = 0
    var razas = ""
    var clase = ""
    var inventario = mutableListOf<Objeto>()
    var cantidadmonedas = mutableListOf<Int>()



    //contructor
    constructor(nombre: String, estadoVital: Int, razas: String, clase: String) {
        this.nombre = nombre
        this.estadoVital = estadoVital
        this.razas = razas
        this.clase = clase
    }

    constructor() {}


    //impresión
    override fun toString(): String {
        return "nombre='$nombre'," +
                "capacidadPesoMochilaMax=$capacidadPesoMochilaMax, " +
                "estadoVital = $estadoVital," +
                "razas = $razas," +
                "clase = $clase)"
    }

    fun toStringInventario(): String {
        var a = ""
        for (i in inventario.indices) {
            a += "\nId: " + inventario[i].id +" peso: " +  inventario[i].peso + " valor: " + inventario[i].valor
        }
        return a
    }

}

//IGNORAR -----------------------------------------------
/*fun getKD(): Double {
    return kills.toDouble() / deaths.toDouble()
}

fun getDetalles(): String {
    return "El jugador $nombre lleva $partidasJugadas partidas jugadas en $tiempoJugado horas jugadas, con un resultado de $kills bajas por $deaths muertes. Por tanto el K/D es de ${getKD()}"
}
 --------------------------------------------------   */

//FUNCIONES DE SET NOMBRE, EDAD, CLASE Y RAZA Y UNA FUNCION DEFINIR PERSONAJE Y ES MERCADER
fun esMercader(personaje :Jugador): Boolean {
    return personaje.clase.lowercase() == "Mercader".lowercase()
}

fun definirPersonaje (personaje: Jugador) : Jugador {
    setNombre(personaje)
    setEdad(personaje)
    setClase(personaje)
    setRaza(personaje)

    return personaje
}

fun setEdad(personaje: Jugador):Jugador {
    do {
        try {
            println("¿Cuántos años quieres que tenga el jugador: ${personaje.nombre}?")
            personaje.estadoVital = readLine()!!.toInt()
        } catch (e: NumberFormatException) {
            val rojo = "\u001B[31m" ; val reset = "\u001B[0m"
            println(rojo + "ERROR, Debías introducir un número, aquí tienes una oportunidad más antes de FATAL ERROR" + reset)
            println("¿Cuántos años quieres que tenga el jugador: ${personaje.nombre}?")
            personaje.estadoVital = readLine()!!.toInt()
        }
    }while (personaje.estadoVital !in 1..10000000)
    return personaje
}
fun setClase(personaje: Jugador): Jugador {
    do {
        println("¿Cual es la clase que quieres que tenga el jugador: ${personaje.nombre}?")
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
    do {
        println("¿Cual es el nombre que quieres que tenga el jugador: ${personaje.nombre}?")
        personaje.nombre = readLine()!!
    }while (personaje.nombre == "")
    return personaje
}
