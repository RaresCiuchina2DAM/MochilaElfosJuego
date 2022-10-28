
fun vender(personaje: Jugador, objeto: Objeto): String {
    var resultado = ""
    if (personaje.inventario.contains(objeto)) {
        personaje.inventario.remove(objeto)
        personaje.sumValor += objeto.valor
        resultado = "Has vendido el objeto ${objeto.id} por ${objeto.valor} Puermacoins"
    } else {
        resultado = "No tienes el objeto ${objeto.id} en la mochila"
    }
    return resultado
}