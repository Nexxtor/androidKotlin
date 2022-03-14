package com.naldana.estructuraproyecto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) // Establece el contenido visual de la Activity
        val greetingTextView: TextView = findViewById(R.id.greeting_text_view) // Se obtiene referencia
        greetingTextView.text = "Probando cambiar texto" // Se modifica el texto en pantalla
    }
}