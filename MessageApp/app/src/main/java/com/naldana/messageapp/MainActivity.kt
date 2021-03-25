package com.naldana.messageapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var messageEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bind()
        setupListeners()
    }

    private fun bind() {
        messageEditText = findViewById(R.id.message_text_input_edit)
    }

    private fun setupListeners() {
        onWatch()
        onSend()
    }

    private fun onWatch() {
        val watchButton = findViewById<Button>(R.id.action_watch)
        val displayTextView = findViewById<TextView>(R.id.message_text_view)
        watchButton.setOnClickListener {
            displayTextView.text = messageEditText.text.toString()
        }
    }

    private fun onSend() {
        val sendButton = findViewById<Button>(R.id.action_send)
        sendButton.setOnClickListener {
            val intent = Intent(this, DataActivity::class.java)
            intent.putExtra(DataActivity.KEY_MESSAGE, messageEditText.text.toString())
            startActivity(intent)
        }
    }
}