package com.naldana.counterpeople

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

private const val IN_COUNTER = "IN_COUNTER"
private const val OUT_COUNTER = "OUT_COUNTER"

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
        Log.d(TAG, "OnCreate")

        savedInstanceState?.let {
            counterEntrada = it.getInt(IN_COUNTER, 0)
            counterSalida = it.getInt(OUT_COUNTER, 0)
        }

        counterEntradaTextView.text = counterEntrada.toString()
        counterSalidaTextView.text = counterSalida.toString()
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "OnStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "OnResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "OnStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "OnDestroy")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "OnRestart")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(IN_COUNTER, counterEntrada)
        outState.putInt(OUT_COUNTER, counterSalida)
        Log.d(TAG, "onSaveInstanceState")
    }


    private fun addEventListeners() {
        addOneEntradaButton.setOnClickListener {
            handlerAddEntrada(1)
        }

        addOneSalidaButton.setOnClickListener {
            handlerAddSalida(1)
        }
    }

    fun onAddCounter(view: View) {
        when (view.id) {
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

    companion object {
        val TAG = MainActivity::class.simpleName
    }

}