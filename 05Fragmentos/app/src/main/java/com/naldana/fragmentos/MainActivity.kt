package com.naldana.fragmentos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import kotlin.random.Random

class MainActivity : AppCompatActivity(), SumFragment.OnActionListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()

        val fragment = SumFragment.newInstance(2, 5)
        fragmentTransaction
            .add(R.id.framelayout_fragment, fragment)
            .commit()

        val cambiar: Button = findViewById(R.id.action_cambiar)

        cambiar.setOnClickListener {
            val n1 = (1..100).random()
            val n2 = (1..100).random()
            val fragmentLocal = SumFragment.newInstance(n1, n2)
            fragmentManager
                .beginTransaction()
                .replace(R.id.framelayout_fragment, fragmentLocal)
                .addToBackStack("$n1+$n2")
                .commit()
        }

    }

    override fun onActionClick(result: Int) {
        Toast
            .makeText(this, "El resultado es $result", Toast.LENGTH_SHORT)
            .show()
    }
}