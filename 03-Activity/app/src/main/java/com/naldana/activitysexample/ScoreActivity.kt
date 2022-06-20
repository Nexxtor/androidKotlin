package com.naldana.activitysexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ScoreActivity : AppCompatActivity() {

    //
    private var scoreTeamA = 0
    private var scoreTeamB = 0

    //View
    private lateinit var scoreTeamATextView:  TextView
    private lateinit var scoreTeamBTextView:  TextView
    private lateinit var statusTeamA: TextView
    private lateinit var statusTeamB: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_score)
        bind()
        intent?.let { intent ->
            scoreTeamA = intent.getIntExtra(MainActivity.KEY_SCORE_TEAM_A, 0)
            scoreTeamB = intent.getIntExtra(MainActivity.KEY_SCORE_TEAM_B, 0)
        }
        fillScoreBoard()
    }

    private fun bind() {
        scoreTeamATextView = findViewById(R.id.score_team_a_text_view)
        scoreTeamBTextView = findViewById(R.id.score_team_b_text_view)
        statusTeamA = findViewById(R.id.status_team_a_text_view)
        statusTeamB = findViewById(R.id.status_team_b_text_view)
    }

    private fun fillScoreBoard() {
        scoreTeamATextView.text = scoreTeamA.toString()
        scoreTeamBTextView.text = scoreTeamB.toString()

        if (scoreTeamA == scoreTeamB) {
            statusTeamA.text = getString(R.string.text_winner)
            statusTeamB.text = getString(R.string.text_winner)
        } else if ( scoreTeamA > scoreTeamB) {
            statusTeamA.text = getString(R.string.text_winner)
            statusTeamB.text = getString(R.string.text_losser)
        } else {
            statusTeamB.text = getString(R.string.text_winner)
            statusTeamA.text = getString(R.string.text_losser)
        }
    }
}