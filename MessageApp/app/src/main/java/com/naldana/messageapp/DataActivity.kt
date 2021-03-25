package com.naldana.messageapp

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DataActivity : AppCompatActivity() {

    companion object {
        const val KEY_MESSAGE = "KEY_MESSAGE"
    }

    private lateinit var messageTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data)
        bind()
        getIntentData()
    }

    private fun bind() {
        messageTextView = findViewById(R.id.message_text_view)
    }

    private fun getIntentData() {
        val message = intent.getStringExtra(KEY_MESSAGE)
        messageTextView.text =
            if (message.isNullOrBlank()) getString(R.string.empty_message) else message

    }
}