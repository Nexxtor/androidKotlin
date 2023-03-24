package com.bdev.laboratorio04

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    // declare the views
    private lateinit var nameEditTextValue: EditText
    private lateinit var emailEditTextValue: EditText
    private lateinit var cellphoneNumberEditTextValue: EditText
    private lateinit var actionSaveButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding()
        setOnClickListeners()
    }

    private fun binding() {

        // bind the views to the variables
        nameEditTextValue = findViewById(R.id.name_edit_text_value)
        emailEditTextValue = findViewById(R.id.email_edit_text_value)
        cellphoneNumberEditTextValue = findViewById(R.id.cellphone_number_edit_text_value)
        actionSaveButton = findViewById(R.id.action_save_button)
    }

    private fun setOnClickListeners() {
        actionSaveButton.setOnClickListener {

            // get the values from the views
            val name = nameEditTextValue.text.toString()
            val email = emailEditTextValue.text.toString()
            val cellphone = cellphoneNumberEditTextValue.text.toString()

            // create the intent
            val intent = Intent(this, ShareActivity::class.java)

            // put the values in the intent
            intent.putExtra("name", name)
            intent.putExtra("email", email)
            intent.putExtra("cellphone", cellphone)

            // start the activity
            startActivity(intent)
        }
    }
}