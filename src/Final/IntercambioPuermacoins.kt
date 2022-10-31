package Final

fun cambioMonedas (dinero : Int) : MutableList<Int> {
    var dinero = dinero
    var monedas = intArrayOf (100,25,10,5,1)
    var cambio = IntArray(monedas.size)
    var i = 0
    while (dinero > 0) {
        if (dinero >= monedas[i]) {
            dinero -= monedas[i]
            cambio[i]++
        } else {
            i++
        }
    }
    return cambio.toMutableList()
}

fun toStringDinero(dinero : Int) : String {
    var cambio = cambioMonedas(dinero)
    var monedas = intArrayOf (100,25,10,5,1)
    var resultado = ""
    for (i in cambio.indices) {
        resultado += "${cambio[i]} monedas de ${monedas[i]} puermacoins, "
    }
    return resultado
}

//Pasar de IntArray a Int

fun IntArrayToInt (cambio : List<Int>) : Int {
    var monedas = intArrayOf (100,25,10,5,1)
    var resultado = 0
    for (i in cambio.indices) {
        resultado += cambio[i] * monedas[i]
    }
    return resultado
}