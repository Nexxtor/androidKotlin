package com.naldana.conversor

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()
    private lateinit var dolaresEditText: EditText
    private lateinit var yuanesEditText: EditText
    private lateinit var convertirButton: Button
    private lateinit var previewDolares: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bind()

        viewModel.dolares.observe(this) { newDolares ->
            val dolares = newDolares.toString()
            dolaresEditText.setText(dolares)
            previewDolares.text = dolares
        }

        viewModel.yuanes.observe(this) { newYuanes ->
            yuanesEditText.setText(newYuanes.toString())
        }

        convertirButton.setOnClickListener {
            viewModel.setDolares(dolaresEditText.text.toString().toDouble())
        }
    }

    private fun bind() {
        dolaresEditText = findViewById(R.id.dolares_text_input)
        yuanesEditText = findViewById(R.id.yuanes_text_input)
        convertirButton = findViewById(R.id.action_convertir)
        previewDolares = findViewById(R.id.dolares_live)
    }
}