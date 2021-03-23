package com.naldana.gamescore

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private var scoreTeamA = 0
    private var scoreTeamB = 0
    private lateinit var scoreTeamATextView: TextView
    private lateinit var scoreTeamBTextView: TextView
    private lateinit var addScoreTeamA: Button
    private lateinit var addScoreTeamB: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity_layout)
        bind()
        //addEvenListeners()
    }

    private fun bind() {
        scoreTeamATextView = findViewById(R.id.text_view_counter_team_a)
        addScoreTeamA = findViewById(R.id.action_plus_team_a)
        scoreTeamBTextView = findViewById(R.id.text_view_counter_team_b)
        addScoreTeamB = findViewById(R.id.action_plus_team_b)
    }


    /**
     * Evento agregado desde XML
     */
    fun increaseScore(view: View) {
        when (view.id) {
            R.id.action_plus_team_a -> handleAddOneTeamA(1)
            R.id.action_plus_team_b -> handleAddOneTeamB(1)
        }
    }

    /**
     * Para agregar los eventos desde codigo fuente
     */
    private fun addEvenListeners() {
        addScoreTeamA.setOnClickListener {
            handleAddOneTeamA(1)
        }
        addScoreTeamB.setOnClickListener {
            handleAddOneTeamB(1)
        }
    }

    private fun handleAddOneTeamA(points: Int) {
        scoreTeamA+=points
        scoreTeamATextView.text = scoreTeamA.toString()
    }

    private fun handleAddOneTeamB(points: Int) {
        scoreTeamB+=points
        scoreTeamBTextView.text = scoreTeamB.toString()
    }
}