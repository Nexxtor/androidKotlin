package com.naldana.viewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

    private lateinit var nameEditText: EditText
    private lateinit var displayNameTextView: TextView
    private lateinit var sendButton: Button

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bind()
        addListeners()
        updateGreeting()
    }

    private fun bind(){
        nameEditText = findViewById(R.id.name_edit_text)
        displayNameTextView = findViewById(R.id.greeting_text_view)
        sendButton = findViewById(R.id.send_action)
    }

    private fun addListeners() {
        sendButton.setOnClickListener {
            viewModel.name = nameEditText.text.toString()
            updateGreeting()
        }
    }

    private fun updateGreeting() {
        displayNameTextView.text = viewModel.getGreeting()
    }
}