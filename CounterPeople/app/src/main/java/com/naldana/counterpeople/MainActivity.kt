package com.naldana.counterpeople

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

private const val IN_COUNTER = "IN_COUNTER"
private const val OUT_COUNTER = "OUT_COUNTER"

class MainActivity : AppCompatActivity(), CounterFragment.OnCounterChange {

    private var counterIn = 0
    private var counterOut = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity_layout)
        savedInstanceState?.let {
            counterIn = it.getInt(IN_COUNTER, 0)
            counterOut = it.getInt(OUT_COUNTER, 0)
        }
        val manager = supportFragmentManager

        val inCounterFragment =
            CounterFragment.newInstance(getString(R.string.text_entrada), counterIn)
        val outCounterFragment =
            CounterFragment.newInstance(getString(R.string.caption_salida), counterOut)

        manager.beginTransaction()
            .replace(R.id.fragment_in, inCounterFragment)
            .replace(R.id.fragment_out, outCounterFragment)
            .commit()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(IN_COUNTER, counterIn)
        outState.putInt(OUT_COUNTER, counterOut)
        Log.d(TAG, "onSaveInstanceState")
    }

    companion object {
        val TAG = MainActivity::class.simpleName
    }

    override fun onChange(captionCounter: String, counterValue: Int) {
        when (captionCounter) {
            getString(R.string.text_entrada) -> counterIn = counterValue
            getString(R.string.caption_salida) -> counterOut = counterValue
        }
    }

}