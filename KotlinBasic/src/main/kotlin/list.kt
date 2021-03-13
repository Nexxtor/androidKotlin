fun main(args: Array<String>) {
    val school = listOf("uca", "udb", "ues")
    println(school)
    var myList = mutableListOf("kotlin", "java", "js")
    println(myList)
    myList.remove("js")
    println(myList)
    myList.add("C#")
    println(myList)

    val schoolArray = arrayOf("uca", "ues", "udb")
    println(java.util.Arrays.toString(schoolArray))

    val mix = arrayOf("fish", 2)
    val numbers = intArrayOf(1, 2, 3)
    val number2 = intArrayOf(4, 5, 6)
    val array = numbers + number2

    val list = listOf("a", "b", "c")
    val list2 = listOf(numbers, list, 100)
    println(list2)

    val array2 = Array(5) { index ->
        index * 2
    }

    println(java.util.Arrays.toString(array2))

    for (element in school) {
        println(element)
    }

    for ((index, element) in school.withIndex()) {
        println("Index: $index Element: $element")
    }

    for (i in 1..5) print(i)
    println()
    for (i in 5 downTo 1) print(i)
    println()
    for (i in 3..6 step 2) print(i)
    println()
    for (i in 'a'..'q') print(i)
    println()

    var bubbles = 0
    while (bubbles < 50) {
        bubbles++
    }

    println("$bubbles burbujas en el agua")

    do {
        bubbles--
    } while (bubbles > 50)

    println("$bubbles burbujas en el agua")

    repeat(2) {
        println("Tienen dudas?")
    }
}