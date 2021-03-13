fun main(args: Array<String>) {
    val plants: Int = 1 // non-null
    var cars: Int? = null  // nulleable

    println(plants)
    println(cars ?: "Es nulo")

    // ? Only Safe
    val plantsDouble = plants.toDouble()
    val carsDouble = cars?.toDouble()

    println(plantsDouble)
    println(carsDouble)
    // !! non-null asserted
    cars = 10
    val carsByte = cars!!.toByte()
    print(carsByte)
}