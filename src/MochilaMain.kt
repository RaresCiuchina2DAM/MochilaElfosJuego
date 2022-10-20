import kotlin.math.max

fun main() {
    val Ladron = Jugador("Ladrón","Jack",10,25,"","")
    var objeto1 = Objeto(8,30)
    var objeto2 = Objeto(6, 80)
    var objeto3 = Objeto(4,96)
    var objeto4 = Objeto(1,120)
    val listaObjetos = arrayOf<Objeto>(objeto1,objeto2,objeto3,objeto4)


    Robar(Ladron,listaObjetos)


}

fun Robar(Ladron : Jugador , articulos : Array<Objeto> ){
    //Saca la rentabilidad de cada objeto y lo añade en orden a un array del mismo tamaño que el original
    val rentabilidad = Array<Double>(size = articulos.size){0.00}
    for (i  in articulos.indices) {
        rentabilidad[i] = (articulos[i].valor / articulos[i].peso).toDouble()
        println(rentabilidad[i])
        }

    //Recorre el array una y otra vez, hasta que no entre nada más en la mochila
    while (Ladron.capacidadPesoMochilaMax > Ladron.sumPeso && rentabilidad.max() != 0.0){
        for (i in rentabilidad.indices) {
            if ( rentabilidad[i] == rentabilidad.max() ) {
                if (Ladron.sumPeso + articulos[i].peso > Ladron.capacidadPesoMochilaMax ){
                    Ladron.sumPeso //no sufre modificaciones
                    Ladron.sumValor //no sufre modificaciones
                }
                if (Ladron.sumPeso + articulos[i].peso <= Ladron.capacidadPesoMochilaMax) {
                    Ladron.sumPeso += articulos[i].peso
                    Ladron.sumValor += articulos[i].valor
                }

                rentabilidad[i] = 0.0
                articulos[i].valor = 0
                articulos[i].peso = 0
            }

        }
    }
    //imprime el contenido
    println(Ladron.toString() + "Peso = " +Ladron.sumPeso + " Valor = " + Ladron.sumValor )



}



