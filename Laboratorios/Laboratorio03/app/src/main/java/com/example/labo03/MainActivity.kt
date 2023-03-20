package com.example.labo03

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import kotlin.math.roundToInt

class MainActivity : AppCompatActivity() {

    private var result: Double = 0.0
    private var resultTV: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var fiveCents: ImageView = findViewById(R.id.fiveCents)
        var tenCents: ImageView = findViewById(R.id.tenCents)
        var quarter: ImageView = findViewById(R.id.quarter)
        var dollar: ImageView = findViewById(R.id.oneDollar)
        resultTV = findViewById(R.id.Money)

        fiveCents.setOnClickListener {add(0.05)}
        tenCents.setOnClickListener {add(0.10)}
        quarter.setOnClickListener {add(0.25)}
        dollar.setOnClickListener {add(1.0)}

    }

    private fun add (value: Double){
        result += value
        val round = (result * 1000.0).roundToInt().toDouble() / 1000.0

        resultTV?.text = round.toString()
    }
}