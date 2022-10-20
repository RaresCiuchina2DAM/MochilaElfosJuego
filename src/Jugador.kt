class Jugador {
    //variables
    var sumValor = 0
    var sumPeso = 0
    var oficio = ""
    var nombre = ""
    var capacidadPesoMochilaMax = 0.0
    var estadoVital = 0
    var razas = ""
    var clase = ""


    //contructor
    constructor(oficio: String, nombre: String, capacidadPesoMochilaMax: Int, estadoVital : Int , razas : String , clase : String) {
        this.oficio = oficio
        this.nombre = nombre
        this.capacidadPesoMochilaMax = capacidadPesoMochilaMax.toDouble()
        this.estadoVital =estadoVital
        this.razas = razas
        this.clase = clase
    }

    //impresión
    override fun toString(): String {
        return "Jugador(oficio='$oficio'," +
                " nombre='$nombre'," +
                " capacidadPesoMochilaMax=$capacidadPesoMochilaMax, " +
                "estadoVital = $estadoVital,"+
                "razas = $razas," +
                "clase = $clase)"
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


    //Objeto a robar
    class Objeto {
        private var peso = 0
        var valor = 0

        constructor(peso : Int , valor : Int){
            this.peso=peso
            this.valor=valor
        }

    }
