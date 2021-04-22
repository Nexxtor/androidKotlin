package com.naldana.livedataexample

import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doAfterTextChanged
import java.util.*

class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()
    private lateinit var messageEditText: EditText
    private lateinit var displayMessage: TextView
    private lateinit var displayMessageCaps: TextView
    private lateinit var displayMessageLowerCase: TextView
    private lateinit var displayMessageNumbers: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bind()
        messageEditText.setText(viewModel.message.value.toString())
        messageEditText.doAfterTextChanged { editable ->
            viewModel.setMessage(editable.toString())
        }

        viewModel.message.observe(this) { message ->
            displayMessage.text = message
            displayMessageCaps.text = message.toUpperCase(Locale.ROOT)
        }

        viewModel.messageLowerCase.observe(this) { message ->
            displayMessageLowerCase.text = message
        }

    }

    private fun bind() {
        messageEditText = findViewById(R.id.message_text_input)
        displayMessage = findViewById(R.id.message_text_view)
        displayMessageCaps = findViewById(R.id.message_caps_text_view)
        displayMessageLowerCase = findViewById(R.id.message_lowercase_text_view)
        displayMessageNumbers = findViewById(R.id.message_numeric_text_view)
    }
}