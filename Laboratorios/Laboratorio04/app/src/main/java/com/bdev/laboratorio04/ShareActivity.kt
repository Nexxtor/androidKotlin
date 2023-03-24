package com.bdev.laboratorio04

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ShareActivity : AppCompatActivity() {

    // declare the views
    private lateinit var nameTextView: TextView
    private lateinit var emailTextView: TextView
    private lateinit var cellphoneNumberTextView: TextView
    private lateinit var actionShareButton: Button

    private var name = ""
    private var email = ""
    private var cellphoneNumber = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_share)
        binding()
        setTextViews()
        setOnClickListeners()
    }

    private fun binding() {
        // bind the views to the variables
        nameTextView = findViewById(R.id.name_text_view)
        emailTextView = findViewById(R.id.email_text_view)
        cellphoneNumberTextView = findViewById(R.id.cellphone_number_text_view)
        actionShareButton = findViewById(R.id.action_share_button)
    }

    private fun setTextViews() {
        // get the values from the intent
        name = intent.getStringExtra("name").toString()
        email = intent.getStringExtra("email").toString()
        cellphoneNumber = intent.getStringExtra("cellphone").toString()

        // set the values in the views
        nameTextView.text = name
        emailTextView.text = email
        cellphoneNumberTextView.text = cellphoneNumber
    }

    private fun setOnClickListeners() {
        actionShareButton.setOnClickListener {
            // create the intent
            val shareIntent = Intent(Intent.ACTION_SEND)

            // put the values in the intent
            shareIntent.type = "text/plain"
            shareIntent.putExtra(Intent.EXTRA_TEXT, "Name: $name\nEmail: $email\nCellphone: $cellphoneNumber")

            // start the activity with the intent and the chooser
            startActivity(Intent.createChooser(shareIntent, "Share to:"))
        }
    }
}