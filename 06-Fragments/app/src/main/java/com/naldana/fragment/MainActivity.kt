package com.naldana.fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragmentManager = supportFragmentManager

        //val fragment = CounterFragment()
        val fragment = DataFragment.newInstance("Nestor", "Aldana")

        fragmentManager.beginTransaction()
            .add(R.id.counter_dinamy_fragment, fragment)
            .add(
                R.id.counter_dinamy_fragment,
                DataFragment.newInstance("Carmen", "SantaCruz")
            )
            .commit()

    }
}