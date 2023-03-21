package com.naldana.fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val fragmentManager = supportFragmentManager

        val fragment = TextFragment()

        fragmentManager
            .beginTransaction()
            .add(R.id.fragment_frame_layout, fragment)
            .add(R.id.fragment_frame_layout, GreetingFragment
                .newInstance("Santiago", "Rodriguez"))
            .commit()

    }
}