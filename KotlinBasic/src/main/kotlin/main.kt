

fun main(args: Array<String>) {

    // Operacion artimeticas
    1 + 2
    1 - 3
    2 / 5 // 0
    2.0 / 5 // 0.x
    0.1

    // Funcione para tipo de dato Numero
    2.times(3) // 6

    3.5.plus(4) // 7.5

    // VAR vs VAL
    var numero: Int = 6
    println(numero)
    numero = 5
    println(numero)

    val valor:Int  = 4
    println(valor)
    // valor = 3 // No se puede reasignar

    var v1 = 5
    println(v1)
    var v2 = v1.toDouble()
    println(v2)

    val oneMillon = 1_000_000
    val hex = 0xFF_EC_DE_5E
    val bytes = 0b011

    println(bytes)

    val numberOfCar = 5
    val numberOfMoto = 10
    println("Yo tengo $numberOfCar carros" + " y $numberOfMoto motos")

    println("Yo tengo ${numberOfCar + numberOfMoto} motos y carros")

    if ( numberOfCar < 5) {
        println("Me robaron un carro")
    } else {
        println("Todo bien!")
    }

    if (numberOfCar == 0) {
        println("El garage esta vacio")
    } else if( numberOfCar == 5) {
        println("todos los carros")
    } else {
        println("Else")
    }
    if( numberOfMoto in 1..4) {
        println("Me faltan motos")
    } else {
        println("Tengo mas de 4 motos")
    }
    when(numberOfCar) {
        0 -> {
            println("el garre esta vacio")
        }
        in 1..4 -> print("Faltan carros")
        else -> print("Todo bien")
    }


}