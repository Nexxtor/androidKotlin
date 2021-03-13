import kotlin.random.Random

fun main(args: Array<String>) {
    println("Hola, ${args[0]}")

    // CASI TODO EN KOTLIN ES UN VALOR
    val isUnit = println("Hola...")
    println(isUnit)

    val temperature = 30
    val isHot = if (temperature > 35.7) true else false
    println(isHot)

    val message = "La tempeartur es ${if (temperature > 35.7) "alta" else "buena"}"
    println(message)

    feedTheFish()
    swim()
    swim(speed = "slow")

    // Ansiosas eager Perezosas lazy

    val list = listOf("moviles", "analisis s", "analisis al")

    println(list)
    println(list.filter {
        it[0] == 'a'
    })
    var myFilter = list.map {
        println("MAP $it")
        it
    }

    var myFilter2 = list.asSequence().map {
        println("Sequence: $it")
        it
    }

    println(myFilter.first())
    println(myFilter2.first())

    println(myFilter)
    println(myFilter2.toList())

    var dirtyLevel = 20
  //  val waterFilter = { dirty:Int -> dirty/2 } //lambda
    val waterFilter: (Int) -> Int = { dirty -> dirty/2}
    println(waterFilter(dirtyLevel))
    println(waterFilter(30))

    println(updateDirty(30, waterFilter))

    println(updateDirty(15,::inscreaseDirty))

    println(updateDirty(2) { level ->
        level * 4
    })
}

fun inscreaseDirty(start:Int) = start + 1

fun updateDirty(dirty:Int, operation: (Int) -> Int ): Int {
    return operation(dirty)
}

fun feedTheFish() {
    val day = ramdonDay()
    val food = fishFood(day)
    println("El dia $day el pezcado comio $food")
}

fun ramdonDay(): String {
    val week = listOf("L", "M", "X", "J", "V", "S", "D")
    return week[Random.nextInt(week.size)]
}

fun fishFood(day: String): String {
    return when (day) {
        "L" -> "A"
        "M" -> "B"
        "X" -> "C"
        "J" -> "D"
        "V" -> "E"
        "S" -> "F"
        "D" -> "G"
        else -> ""
    }
}

fun isHot(temperature: Int) = temperature > 37.5

fun swim(speed: String = "fast", glass: String = "none") {
    println("Swimmign $speed")
}





