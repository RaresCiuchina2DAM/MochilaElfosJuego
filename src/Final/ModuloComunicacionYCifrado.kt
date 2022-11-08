package Final

import java.util.*

fun comunicacion (respuesta : String, jugador: Jugador): String {

    when (jugador.estadoVital) {
        in 0..21 ->
            if (esMayuscula(respuesta) &&
                respuesta.get(index = 0) == '¿' &&
                respuesta.get(index = respuesta.length-1) == '?'
            ) {
                return "Tranqui, se lo que hago"
            } else if (respuesta.equals("¿Como estas?")) {
                return "De lujo"
            } else if (esMayuscula(respuesta)) {
                return "Eh , relajate"
            } else if (respuesta == jugador.nombre) {
                return "¿Que pasa?"
            } else return "Yo que sé"

        in 22..65 ->
            if (esMayuscula(respuesta) &&
                respuesta.get(index = 0) == '¿' &&
                respuesta.get(index = respuesta.length-1) == '?'
            ) {
                return "Estoy buscando la mejor solución"
            } else if (respuesta.equals("¿Como estas?")) {
                return "En la flor de la vida,\n" +
                        "pero me empieza a doler la espalda"

            } else if (esMayuscula(respuesta)) {
                return "No me levantes la voz mequetrefe"
            } else if (respuesta == jugador.nombre) {
                return "¿Necesitas algo?"
            } else return "No sé de qué me estás hablando"

        else ->
            if (esMayuscula(respuesta) &&
                (respuesta.get(index = 0) == '¿') &&
                (respuesta.get(index = respuesta.length-1) == '?')
            ) {
                return "Que no te escucho!"
            } else if (respuesta.equals("¿Como estas?")) {
                return "No me puedo mover"
            } else if (esMayuscula(respuesta)) {
                return "Háblame más alto que no te escucho"
            } else if (respuesta == jugador.nombre) {
                return "Las 5 de la tarde"
            } else return "En mis tiempos esto no pasaba"

    }
}


//FUNCIONES DE COMUNICACIÓN
fun esMayuscula(s: String): Boolean {
    return s == s.uppercase(Locale.getDefault())
}

//FUNCIONES HABLAR CON EL USUARIO
fun hablarConJugador(texto: String, jugador: Jugador): String {

    if (jugador.razas.equals("Humano",true)) {
        return comunicacion(texto, jugador)
    }else if (jugador.razas.equals("Elfo",true)){
        return cifradoCesar(comunicacion(texto, jugador),13)
    }else if (jugador.razas.equals("Enano",true)){
        return comunicacion(texto,jugador).lowercase()
    }else if (jugador.razas.equals("Goblin",true)){
        return cifradoCesar(comunicacion(texto, jugador),8)
    }
    else return "a"
}

fun cifradoCesar(texto: String, codigo: Int): String {
    var texto1 = texto.lowercase()
    var codigo = codigo
    val cifrado = StringBuilder()
    codigo %= 26
    for (i in texto1.indices) {
        if (texto1[i] in 'a'..'z') {
            if (texto1[i].code + codigo > 'z'.code) {
                cifrado.append((texto1[i].code + codigo - 26).toChar())
            } else {
                cifrado.append((texto1[i].code + codigo).toChar())
            }
        }
    }
    return cifrado.toString()
}

fun hablar(personajeMercader: Jugador) {
    var respuesta = ""
    println("¿Que quieres decirle?")
    respuesta = readLine()!!
    while (respuesta.lowercase() != "Adios".lowercase()) {
        hablarConJugador(respuesta, personajeMercader)
        println("¿Que quieres decirle?")
        respuesta = readLine()!!
    }
}

