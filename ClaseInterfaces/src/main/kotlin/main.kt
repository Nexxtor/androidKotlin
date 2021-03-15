import clases.*

fun buildPerson() {
    val person = Person("Néstor", "Aldana") // Instance
    person.printIdentity()
    println(person.code)
    val person2 = Person("Santiago,Aldana") // Instance
    person2.printIdentity()
    println(person2.code)
    person2.code = "as"
    println(person2.tempoCode)
    Person.printCompany()
    person2.birthDay()
}

fun buildCiclo() {
    val ciclo = object: Ciclo() {
        override fun asignarEvaluacion() {
            TODO("Not yet implemented")
        }
    }
}

fun buildRetirar() {
    val retirar: Retirar = Estudiante()
    retirar.retirar("As",10)
}

fun main(args: Array<String>) {
    buildPerson()
    var estudiante = Estudiante.getInstace()
    println(Color.RED)
    var cadena = "Next"
    cadena.hasSpaces()

    val list = listOf(1,2,3,4,5,6,7)
    val twoList = list.partition { it >= 4 }
    println(twoList.first)
    println(twoList.second)

    val ponderacion  = "tarea 1" to 0.5
    println(ponderacion.first)
    println(ponderacion.second)

    val numbers = Triple(1,2,3)

    val ponderacion2  = "moviles" to ("tarea 1" to 0.5)

    val(evalucion, valor) = ponderacion
    println(evalucion)
    println(valor)
}

fun String.hasSpaces(): Boolean {
    val found = this.find { it == ' ' }
    return found != null
}

fun Person.birthDay() {
    print("Cumpleaños")
}