package com.naldana.counterpeople

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment

class CounterFragment : Fragment() {

    private var captionCounter: String = "NO NAME"
    private var valueCounter: Int = 0
    private lateinit var listener: OnCounterChange

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnCounterChange)
            listener = context
        else
            throw Exception("Is needed a OnCounterChange Instance")
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            captionCounter = it.getString("CAPTION_COUNTER").toString()
            valueCounter = it.getInt("VALUE_COUNTER")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.counter_fragment, container, false).apply {
        findViewById<TextView>(R.id.caption_counter_text_view).text = captionCounter
        val counterTextView = findViewById<TextView>(R.id.counter_text_view)
        counterTextView.text = valueCounter.toString()
        val addOneButton = findViewById<Button>(R.id.action_add_one_counter)
        addOneButton.setOnClickListener {
            valueCounter++
            counterTextView.text = valueCounter.toString()
            listener.onChange(captionCounter, valueCounter)
        }
    }

    companion object {
        fun newInstance(captionCounter: String, counterValue: Int) = CounterFragment().apply {
            arguments = Bundle().apply {
                putString("CAPTION_COUNTER", captionCounter)
                putInt("VALUE_COUNTER", counterValue)
            }
        }
    }

    interface OnCounterChange {
        fun onChange(captionCounter: String, counterValue: Int)
    }
}