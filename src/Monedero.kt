class Monedero {
    var Puermacoins = arrayOf(100, 25, 10, 5, 1)

    //Determina el tipo de Puermacoins que se van a devolveR y los añade a un array
    fun devolverCambio(valor: Int): Array<Int> {
        var cambio = Array<Int>(size = 5) { 0 }
        var valorCambio = valor
        for (i in Puermacoins.indices) {
            if (valorCambio >= Puermacoins[i]) {
                cambio[i] = valorCambio / Puermacoins[i]
                valorCambio %= Puermacoins[i]
            }
        }
        return cambio
    }

    fun toString(cambio: Array<Int>): String {
        var resultado = ""
        for (i in Puermacoins.indices) {
            resultado += "Puermacoins de " + Puermacoins[i] + " = " + cambio[i] + "\n"
        }
        return resultado
    }

}