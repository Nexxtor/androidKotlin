package com.naldana.shareviewmodel

import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.viewModels
import androidx.fragment.app.FragmentManager
import com.naldana.shareviewmodel.ui.MainViewModel
import com.naldana.shareviewmodel.ui.lastname.LastNameFragment
import com.naldana.shareviewmodel.ui.money.MoneyFragment
import com.naldana.shareviewmodel.ui.name.NameFragment

class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()
    private lateinit var backButton: Button
    private lateinit var forwardButton: Button
    private lateinit var fragmentManger: FragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bind()
        fragmentManger = supportFragmentManager
        displayPhase(viewModel.currentPhase())
        addListeners()
    }

    private fun addListeners() {
        backButton.setOnClickListener {
            viewModel.previousPhase()
            displayPhase(viewModel.currentPhase())
        }

        forwardButton.setOnClickListener {
            viewModel.nextPhase()
            displayPhase(viewModel.currentPhase())
        }
    }

    private fun bind() {
        backButton = findViewById(R.id.back_action)
        forwardButton = findViewById(R.id.forward_action)
    }

    private fun displayPhase(phase: Int) {
        val trans = fragmentManger.beginTransaction()
        when(phase) {
            1 -> {
                trans.replace(R.id.fragment_cotainer, NameFragment())
                backButton.visibility = View.GONE
            }
            2 -> {
                trans.replace(R.id.fragment_cotainer, LastNameFragment())
                backButton.visibility = View.VISIBLE
                forwardButton.visibility = View.VISIBLE
            }
            3 -> {
                trans.replace(R.id.fragment_cotainer, MoneyFragment())
                forwardButton.visibility = View.GONE
            }
        }
        trans.commit()
    }

    override fun onBackPressed() {
        if( viewModel.currentPhase() == 1) {
            super.onBackPressed()
        } else {
            viewModel.previousPhase()
            displayPhase(viewModel.currentPhase())
        }

    }
}