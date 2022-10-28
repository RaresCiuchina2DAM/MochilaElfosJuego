import kotlin.random.Random


class Dado(numMin: Int = 1, numMax: Int = 6) {

    private var numMin=1
    private var numMax=6


    fun darValores(valMin: Int, valMax: Int) {
            if (valMin <= valMax) {
                numMax = valMax
                numMin = valMin
            } else {
                println("Se han cambiado los valores min y maximo")
                numMax = valMin
                numMin = valMax
            }
        }

        fun tiradaUnica (): Int {
            return Random.nextInt(numMin, numMax)
        }

        fun tiradaDoble (): Int {
            val num1 = Random.nextInt(numMin, numMax)
            println("num1 = $num1")
            val num2 = Random.nextInt(numMin, numMax)
            println("num2 = $num2")
            return if (num1 == num2) num1 * num2 else num1 + num2
        }
    }
