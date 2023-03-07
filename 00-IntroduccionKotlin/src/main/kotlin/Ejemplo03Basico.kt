/**
 * En este ejemplo encontraras el uso de colecciones mas comunes en kotlin
 * y como recorrelas
 */
fun main(args: Array<String>) {
    val school = listOf("uca", "udb", "ues") // Lista que no puede cambiar sus valores depues de creada
    val numero = 10
    val school2:List<String> = listOf("uca", "udb", "ues")

    println(school)
    var myList = mutableListOf("kotlin", "java", "js") // Lista que puede cambiar sus valores despues de creada
    println(myList)
    myList.remove("js")
    println(myList)
    myList.add("C#")
    println(myList)

    // Arreglos en Kotlin
    val schoolArray = arrayOf("uca", "ues", "udb")
    // Los arreglos se puede mostrar con lista utilizando la clase de utilidad de JAVA
    // para trabajar con arreglos
    // Este es ademas un ejemplo de la interpotabilidad de kotlin
    println(java.util.Arrays.toString(schoolArray))

    // Los arraglas pueden ser mixtos y es por que en kotlin tod o herrada de Any
    val mix = arrayOf("fish", 2) // mixto (Any)
    val numbers = intArrayOf(1, 2, 3)  // todos enteros
    val number2 = intArrayOf(4, 5, 6)
    val array = numbers + number2 // concatenacion de arreglos

    val list = listOf("a", "b", "c")
    val list2 = listOf(numbers, list, 100) // Lista mixta, arreglas , listas y numeros
    println(list2)

    // Crear un arreglo de 5 posicion y cada posicion con el valor de su índice multipliacado con 2
    val array2 = Array(5) { index ->
        index * 2
    }
    println(java.util.Arrays.toString(array2))

    // Reocrer un lista de uno en uno
    for (element in school) {
        println(element)
    }

    // Recorar una lista de uno en uno con su index y element
    for ((index, element) in school.withIndex()) {
        println("Index: $index Element: $element")
    }
    // For de 1 en 1 de 1 a 5
    for (i in 1..5) print(i)
    println()
    // For de 1 en 1 de 5 a 1
    for (i in 5 downTo 1) print(i)
    println()
    // for de 3  a 6 de dos en dos
    for (i in 3..6 step 2) print(i)
    println()
    // for de a hasta q aprovechado la represetancion numerica de los caracteres
    for (i in 'a'..'q') print(i)
    println()

    // Lazo while
    var bubbles = 0
    while (bubbles < 50) {
        bubbles++
    }

    println("$bubbles burbujas en el agua")

    // Lazo do while
    do {
        bubbles--
    } while (bubbles > 50)

    println("$bubbles burbujas en el agua")

    // Repiteir x veces un codigo
    repeat(2) {
        println("Tienen dudas?")
    }
}