package Final

fun main() {
    val Ladron = Jugador("Jack",25,"","")
    var objeto1 = Objeto(1,8,30)
    var objeto2 = Objeto(2, 5, 20)
    var objeto3 = Objeto(3,2,12)
    var objeto4 = Objeto(4,5,38)
    var objeto5 = Objeto(5,1,350)
    val listaObjetos = mutableListOf<Objeto>(objeto1,objeto2,objeto3,objeto4,objeto5)


    robar(Ladron,listaObjetos)



}

fun robar(Ladron: Jugador, articulos: MutableList<Objeto>): MutableList<Objeto> {
    //Saca la rentabilidad de cada objeto y lo añade en orden a un array del mismo tamaño que el original
    val rentabilidad = Array<Double>(size = articulos.size) { 0.00 }
    for (i in articulos.indices) {
        rentabilidad[i] = (articulos[i].valor / articulos[i].peso).toDouble()
    }


    //Recorre el array una y otra vez, hasta que no entre nada más en la mochila
    while (Ladron.capacidadPesoMochilaMax > Ladron.sumPeso && rentabilidad.max() != 0.0) {
        for (i in rentabilidad.indices) {

            if (rentabilidad[i] == rentabilidad.max() && rentabilidad[i] != 0.0) {
                if (Ladron.sumPeso + articulos[i].peso <= Ladron.capacidadPesoMochilaMax) {
                    Ladron.sumPeso += articulos[i].peso
                    Ladron.sumValor += articulos[i].valor

                    Ladron.inventario.add(articulos[i])
                    rentabilidad[i] = 0.0
                    articulos.removeAt(i)
                } else
                    rentabilidad[i] = 0.0

            }
        }

    }

    return Ladron.inventario

}







