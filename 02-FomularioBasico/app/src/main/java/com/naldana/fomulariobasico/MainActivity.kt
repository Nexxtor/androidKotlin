package com.naldana.fomulariobasico

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {

    /*
     * Las siguiente propiedades permiten acceder a los elementos de tipo View
     * declarados el XML. Se declaran como propiedades para poder acceder de
     * forma sencilla en toda la actividad.
     *
     * La palabra clave lateinit permite declarar un atributo si inicializarlo manteniendo
     * la funcionalidad de null-safety.
     */
    private lateinit var nameEditText: EditText
    private lateinit var resultTextView: TextView
    private lateinit var greetingButton: Button

    /*
     * El método onCreate siempre es el primer método en ejecutarse cuando la actividad
     * se muestra en pantalla, se debe configurar el contenido visual enlazar las propiedades con
     * las instancias de los elementos View en pantalla y configurar los eventos.
     * En otras palabras en este método se configuran todas los aspectos necesarios para que
     * la actividad funcione.
     *
     * onCreate se sobrescribe de Activity o de AppCompactActivity y se debe asegurar siempre
     * ejecutar su versión superior.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)  // Ejecutar primero super
        setContentView(R.layout.activity_main) // Crear la interfaz gráfica a partir del archivo activity_main.xml
        bind()
        /* Para agregar un evento de click solo hace falta ejecutar setOnClickListener
         * y definir la acción a ejecutar
         */
        greetingButton.setOnClickListener { view ->
            // En este bloque se puede definir lo que se ejecuta en caso de click
            onGreeting(view)
            // En ese ejemplo se extrae en onGreeting para que el mismo código sea compatible
            // añadir el listener desde XML o desde Código
        }
    }

    /**
     * Une los atributos de la clase con los View en pantalla, obteniendo la referencia a través
     * del método findViewById
     */
    private fun bind() {
        val nameLayout: TextInputLayout = findViewById(R.id.name_edit_text)
        nameEditText = nameLayout.editText!!
        resultTextView = findViewById(R.id.greeting_text_view)
        greetingButton = findViewById(R.id.action_greeting)
    }

    /**
     * Construye un saludo
     * @param name nombre de una persona
     * @return saludo o si instrucciones si name esta vacio
     */
    private fun makeGreeting(name: String) =
        if (name.isEmpty()) {
            // Obtiene un texto desde el archivo Strings
            getString(R.string.helper_greeting)
        } else {
            // Obtiene un texto desde el archivo Strings y pasa parámetros
            getString(R.string.template_greeting, name)
        }

    /**
     * Ejecuta la acción del evento de saludar. Puede ser asignado desde el XML o desde código
     */
    fun onGreeting(view: View) {
        val greeting = makeGreeting(nameEditText.text.toString())
        resultTextView.text = greeting
    }

}