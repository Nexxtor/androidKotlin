package com.example.labo03

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import kotlin.math.roundToInt

class MainActivity : AppCompatActivity() {

    private var result: Double = 0.0

    private lateinit var moneyValueTextView: TextView
    private lateinit var fiveCentsImageView: ImageView
    private lateinit var tenCentsImageView: ImageView
    private lateinit var quarterImageView: ImageView
    private lateinit var dollarImageView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding()
        setOnClickListeners()
    }

    private fun binding() {
        moneyValueTextView = findViewById(R.id.money_value_text_view)
        fiveCentsImageView = findViewById(R.id.five_cents_image_view)
        tenCentsImageView = findViewById(R.id.ten_cents_image_view)
        quarterImageView = findViewById(R.id.quarter_image_view)
        dollarImageView = findViewById(R.id.dollar_image_view)
    }

    private fun setOnClickListeners() {
        fiveCentsImageView.setOnClickListener {add(0.05)}
        tenCentsImageView.setOnClickListener {add(0.10)}
        quarterImageView.setOnClickListener {add(0.25)}
        dollarImageView.setOnClickListener {add(1.0)}
    }

    private fun add (value: Double){
        result += value
        val round = (result * 1000.0).roundToInt().toDouble() / 1000.0

        moneyValueTextView?.text = round.toString()
    }
}