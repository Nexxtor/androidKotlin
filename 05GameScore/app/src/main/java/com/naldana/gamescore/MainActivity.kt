package com.naldana.gamescore

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    // UI elements
    private lateinit var displayTeamA: TextView
    private lateinit var displayTeamB: TextView
    private lateinit var addOneTeamA: Button
    private lateinit var addOneTeamB: Button
    private lateinit var gameOverButton: Button

    // data element
    private var scoreTeamA = 0
    private var scoreTeamB = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bind()

        if(savedInstanceState != null) {
            displayTeamA.text = savedInstanceState?.getInt(TEAM_A_SCORE).toString()
            displayTeamB.text = savedInstanceState?.getInt(TEAM_B_SCORE).toString()
        } else {
            displayTeamA.text = scoreTeamA.toString()
            displayTeamB.text = scoreTeamB.toString()
        }



        addListener()

    }

    private fun bind() {
        displayTeamA = findViewById(R.id.display_score_team_a_text_view)
        displayTeamB = findViewById(R.id.display_score_team_b_text_view)
        addOneTeamA = findViewById(R.id.add_one_team_a_button)
        addOneTeamB = findViewById(R.id.add_one_team_b_button)
        gameOverButton = findViewById(R.id.game_over_action)
    }

    private fun addListener() {
        addOneTeamA.setOnClickListener {
            scoreTeamA++
            displayTeamA.text = scoreTeamA.toString()
        }

        addOneTeamB.setOnClickListener {
            scoreTeamB++
            displayTeamB.text = scoreTeamB.toString()
        }

        gameOverButton.setOnClickListener {
            var intent = Intent(MainActivity@this, ResultActivity::class.java)
            intent.putExtra(TEAM_B_SCORE, scoreTeamB)
            intent.putExtra(TEAM_A_SCORE, scoreTeamA)
            startActivity(intent)
        }

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        outState.apply {
            putInt(TEAM_A_SCORE, scoreTeamA)
            putInt(TEAM_B_SCORE, scoreTeamB)
        }
    }

    companion object {
        const val TEAM_A_SCORE = "TEAM_A_SCORE"
        const val TEAM_B_SCORE = "TEAM_B_SCORE"
    }
}