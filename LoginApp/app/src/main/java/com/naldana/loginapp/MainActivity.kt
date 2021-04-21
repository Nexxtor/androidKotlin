package com.naldana.loginapp

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()
    private lateinit var userField: EditText
    private lateinit var passwordField: EditText
    private lateinit var displayData: TextView
    private lateinit var loginButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bind()
        userField.setText(viewModel.user)
        passwordField.setText(viewModel.password)
        displayData.text = getDisplayData()
        loginButton.setOnClickListener {
            viewModel.user = userField.text.toString()
            viewModel.password = passwordField.text.toString()
            displayData.text = getDisplayData()
        }
    }

    private fun bind() {
        userField = findViewById(R.id.text_user_input)
        passwordField = findViewById(R.id.text_password_input)
        loginButton = findViewById(R.id.action_login)
        displayData = findViewById(R.id.display_data)
    }

    fun getDisplayData() =
            " ${viewModel.user} , ${viewModel.password}"

}