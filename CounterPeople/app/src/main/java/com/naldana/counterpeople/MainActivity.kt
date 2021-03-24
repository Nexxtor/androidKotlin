package com.naldana.counterpeople

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private var counterEntrada = 0
    private var counterSalida = 0

    private lateinit var counterEntradaTextView: TextView
    private lateinit var addOneEntradaButton: Button
    private lateinit var counterSalidaTextView: TextView
    private lateinit var addOneSalidaButton: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity_layout)
        bind()
        // addEventListeners()
    }

    private fun addEventListeners() {
        addOneEntradaButton.setOnClickListener {
            handlerAddEntrada(1)
        }

        addOneSalidaButton.setOnClickListener {
            handlerAddSalida(1)
        }
    }

    fun onAddCounter(view: View){
        when(view.id) {
            R.id.action_add_one_salida -> handlerAddSalida(1)
            R.id.action_add_one_entrada -> handlerAddEntrada(1)
        }
    }
    
    private fun bind() {
        counterEntradaTextView = findViewById(R.id.text_view_counter_entrada)
        addOneEntradaButton = findViewById(R.id.action_add_one_entrada)
        counterSalidaTextView = findViewById(R.id.text_view_counter_salida)
        addOneSalidaButton = findViewById(R.id.action_add_one_salida)
    }

    private fun handlerAddEntrada(add: Int) {
        counterEntrada += add
        counterEntradaTextView.text = counterEntrada.toString()
    }

    private fun handlerAddSalida(add: Int) {
        counterSalida += add
        counterSalidaTextView.text = counterSalida.toString()
    }

}