package clases

class Estudiante : Person(), Retirar by SuperRetirar {

    companion object {
        private var INSTANCE: Estudiante? = null

        fun getInstace(): Estudiante {
            var estudiante: Estudiante? = INSTANCE
            if (INSTANCE == null) {
                estudiante = Estudiante()
                INSTANCE = estudiante
            }
            return estudiante!!
        }
    }

    override var code: String
        get() = super.code
        set(value) {}
}