import kotlin.random.Random

fun main(args: Array<String>) {
    println("Hola, ${args[0]}") // Utilizar parametros desde consola

    // CASI TODO EN KOTLIN ES UN VALOR
    val isUnit = println("Hola...") // Es guardado con Unit, que es el equivalete al tipo VOID
    println(isUnit)

    val temperature = 30
    // el if puede se usado como expresion mientras en su ultima instruccion de la parte verdadera y falsa
    // retorne un valor, en el caso siguiente true y false
    val isHot = if (temperature > 35.7) true else false
    println(isHot)
    // En el siguiente caso es utilizado como expresin para decir que palabra concatenar si "alta" o "buena"
    val message = "La tempeartur es ${if (temperature > 35.7) "alta" else "buena"}"
    println(message)

    feedTheFish() // Ejemplo de funcion si paramentro ni retorno
    swim() // Ejemplo de funcion con parametros por defecto
    swim("slow") // Ejemplo de funcion con parametro por defecto pasando valores
    swim(speed = "slow") // Ejemplo de funcion con parametro por defecto pasando valores, pero utilizando paramentros antados

    // Ejecuciones  eager(Ansiosas) y  lazy (Perezosas)
    // Las ejecuciones eager son aquellas que realizan las tareas de manera inmediate
    // Las ejecucuines lazy son aquellas que se realizan en el momento que se necesitan
    // amabas se ejecutan en el hilo principal, la diferencia es que las lazy son ejecuntan,
    // cuando se solicita

    // ejemplo
    val list = listOf("moviles", "analisis s", "analisis al")

    println(list) // mostar lista
    // Si solisitamos filtar la ejecucion del filtro sera inmediata
    // esto es una funcion eager
    println(list.filter {
        it[0] == 'a'
    })
    // Si mapeamos los valores de las lista con map se ejecutara de inmediato
    // en la consola vermos todos los print de "MAP"
    var myFilter = list.map {
        println("MAP $it")
        it
    }

    // pero si lo hacemos con el objecto asSequence el mapeo de los datos
    // se hara hasta que mas adelante se solicite el dato nuevo
    // EN LA CONSOLA NO VEREMOS UN PRINT DE Sequence hasta que un dato sea llamado
    var myFilter2 = list.asSequence().map {
        println("Sequence: $it")
        it
    }

    println(myFilter.first()) // muesta el dato
    // muestra un prin de Sequnece y luego el dato
    // por que el codigo para maperar el valor en la posicion un fue
    // ejecutado hasta que se necesite
    println(myFilter2.first())

    println(myFilter) // Muestra toda la lista
    // Al pedir todos los valores en formato list veremos las print de Sequence
    println(myFilter2.toList()) // luego todos  los datos


    // Funciones lambada
    var dirtyLevel = 20
    // Guardado funciones en varaibles
    //  val waterFilter = { dirty:Int -> dirty/2 } // lambda  en formato corto
    val waterFilter: (Int) -> Int = { dirty -> dirty/2} // lamfa con tipo de variable
    println(waterFilter(dirtyLevel)) // ejecutando funciones lambda
    println(waterFilter(30))

    // pasando funciones lamda como paramentros
    println(updateDirty(30, waterFilter))
    // pasando funciones definada con fu como paramentros
    println(updateDirty(15,::inscreaseDirty))
    // declarando y pasando funcion lambda como paramentro, sintaxis corta
    println(updateDirty(2) { level ->
        level * 4
    })
}

fun inscreaseDirty(start:Int) = start + 1

// como recibir funciones como parametro
// (Tipo de datos de paramentros) -> Tipo de dato de retorno
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

// funcione compactas, son aquella que esta igualadas a expresiones
fun isHot(temperature: Int) = temperature > 37.5

// paramentros por decfecto
fun swim(speed: String = "fast", glass: String = "none") {
    println("Swimmign $speed")
}





