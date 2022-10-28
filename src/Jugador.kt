class Jugador {
    //Variables
    var sumValor = 0
    var sumPeso = 0
    var nombre = ""
    var capacidadPesoMochilaMax = Dado(0, 0).tiradaUnica()*10.toDouble()
    var estadoVital = 0
    var razas = ""
    var clase = ""
    var inventario = mutableListOf<Objeto>()
    var monedero = Monedero().Puermacoins

    //contructor
    constructor(nombre: String, estadoVital: Int, razas: String, clase: String) {
        this.nombre = nombre
        this.estadoVital = estadoVital
        this.razas = razas
        this.clase = clase
    }
    constructor(){}


    //impresión
    override fun toString(): String {
        return "nombre='$nombre'," +
                "capacidadPesoMochilaMax=$capacidadPesoMochilaMax, " +
                "estadoVital = $estadoVital," +
                "razas = $razas," +
                "clase = $clase)"
    }


    fun toStringInventario() {
        print("Inventario:")
        for (i in inventario.indices) {
            println("\n     Objeto[$i]=" +
                    "\n        id: $i}" +
                    "\n        valor: " + inventario[i].valor.toString() +
                    "\n        peso: " + inventario[i].peso.toString())
        }
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




