package Final

class Objeto {

    var peso = 0
    var valor = 0
    var id = 0

    constructor(id: Int,peso : Int , valor : Int){
        this.id = id
        this.peso=peso
        this.valor=valor
    }
    override fun toString (): String {
        return "Id: $id peso: $peso valor: $valor"
    }
}

