/**
 * En Kotlin todas las variables por defecto son de tipo non-null
 * esto significa que no pueden guardar el dato null
 */
fun main(args: Array<String>) {
    val plants: Int = 1 // non-null
    // Para que una variable pueda guardar null, en su declaracion
    // despues de tipo hay que indicar que es de tipo nuulleable con el
    // simbolo ?
    var cars: Int? = null // nulleable

    println(plants) // Las variable non-null se utilizan normalmente
    // Pero la variables que pueden tener null se ultilizan con dos operadores
    // el operador ? (only safe) y el operador !! (non-null asserted)


    println(cars ?: "Es nulo") // operador elvis ?: si lo que esta a la izquierda es nulo, se devuelve el valor de la derecha

    // ? Only Safe, este operador devuelve null cuando se intenta usar la variable y esta tiene el valor de null
    val plantsDouble = plants.toDouble() // se convertira de forma existosa
    val carsDouble = cars?.toDouble()  // la variable carDouble guardara un valor null y el programa continuara
    println(plantsDouble)
    println(carsDouble) // null

    // !! non-null asserted lanza una exepcion de null pointer si el valor es nulo y si no manejas excepciones
    // con try catch el programa se detiene
    cars = 10
    val carsByte = cars!!.toByte() // no se detiene por que cars tiene un valor, si comenta la linea anterior no lograr compilar
    print(carsByte)

}