package clases

import java.util.*

open class Person(var name: String = "no name", var lastName: String = "no last name") {
    private var hairdColor: Int = 0xFFF
    var tempoCode: String? = null

    companion object { // STATIC
        const val COMPANY = "UCA"
        fun printCompany() {
            println(Person.COMPANY)
        }
    }

    open var code: String
        get() = "${name[0]}${name[1]}$lastName$hairdColor"
        set(value) {
            tempoCode = value
        }

    constructor(completeName: String) : this() {
        val split = completeName.split(",")
        name = split[0]
        lastName = split[1]
    }

    init {
        println("Creando persona")
        Person.printCompany()
    }

    init {
        println("Definiendo color de pelo")
        hairdColor = Math.random().toInt()
    }

    fun printIdentity() {
        println("I'm $name $lastName")
    }
}