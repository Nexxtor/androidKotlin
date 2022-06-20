/**
 * Ejemplo de características fundamentales en Kotlin
 */
fun main(args: Array<String>) {

    /**
     * Todo en Kotlin es un objeto, es decir, que se pueden llamar funciones y propiedades en cualquier variable
     * Pero algunos tipos tiene representación especiales como los números que se representan como primitivos en tiempo
     * de ejecución. Existen dos tipos de números los enteros(Integer Type) y los flotantes(Floating-point Type).
     *
     */

    1 + 2 // Suma
    1 - 3 // Resta
    2 / 5 // División entera, si ambas partes son enteras el resultado es entero.
    2.0 / 5 // División, si alguna de los operadores es un número decimal el resultado será un número decimal.

    /** A pesar de que los números son tratados como datos primitivos, estos se pueden ejecutar funciones como si se tratara de objetos
     */

    2.times(3) // Multiplicación
    3.5.plus(4) // Suma
    // Los valores númericos pueden ser escritos de las siguientes formas
    1000000 // Un millon
    1_000_000 // un millon pero usando _ para mejorar legebilidad
    0xA
    0xFF_FF_FF
    0xFF_EC_DE_5E // Valores Hexdecimales separados con _ para mejorar la legilibidad
    0b011 // Binario

    // En kotlin existen dos tipos de variables cambiables(var) e incambiables(val)
    // La sintaxis es (var | val) <nombreVariable> [: <Type> ] = <valor>
    var numero: Int = 6  // variable cambiable de tipo entero (Int)
    // El tipo de dato se puede omitir si la asignacion del valor es inmediata
    println(numero) // Mostamos el valor
    numero = 5 // probamos si podemos modifcarla
    println(numero) // Mostramas el valor

    val valor: Int = 4 // variable incambiable
    println(valor) // Mostramos el valor
    // valor = 3 // Intetamos cambiar el valor, pero el IDE y el Interprete nos da un error

    var v1 =
        5 // Declaración de variable sin tipo, si la variable sera de solo lectura es mejor cambiar a val
    println(v1) // mostrar el valor 5
    var v2 =
        v1.toDouble() // Entra las funciones que tiene los numeros estan la funcion "to" que sirven para convertir en tipos diferentes
    println(v2) // mostrar el valor 5.0

    // Trabajando con cadena
    val numberOfCar = 5
    val numberOfMoto = 10
    // La concatenación se hace con +
    // Se puede insertar el valor de una variable en una cadena con el simbolo $
    println("Yo tengo $numberOfCar carros" + " y $numberOfMoto motos")
    // Si queremos ejecutar una expresion como una suma, if, llamada a funcion o cualquier otro que devuelva un valor
    // que necesitamos usar en la cadena se usa ${<expresion>}
    println("Yo tengo ${numberOfCar + numberOfMoto} motos y carros")

    // Trabajando con codicionales y comapraciones
    // Condicional con parte verdadera y falsa
    if (numberOfCar < 5) {
        println("Me robaron un carro")
    } else {
        println("Todo bien!")
    }

    // condicional con el operador in
    // Busca que numberOfMoto este en el rango de 1 a 4 inclusive ambos
    // 1..4
    if (numberOfMoto in 1.. 4) {
        println("Me faltan motos")
    } else {
        println("Tengo mas de 4 motos")
    }

    // Condicional con multiples casos, estilo if elseif else
    if (numberOfCar == 0) {
        println("El garage esta vacio")
    } else if (numberOfCar == 5) {
        println("todos los carros")
    } else {
        println("Else")
    }

    // La condiconales con multiples casos es mejor escribirlas con when (Switch en otros lenguajes)
    when (numberOfCar) {
        0 -> { // Cuando se necesita mas de una linea por caso se usan llaves
            println("el garre esta vacio")
        }
        in 1..4 -> print("Faltan carros")
        else -> print("Todo bien")
    }
}