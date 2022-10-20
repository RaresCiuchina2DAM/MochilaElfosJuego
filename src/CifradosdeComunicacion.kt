

//FUNCIONES DE COMUNICACIÓN

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
