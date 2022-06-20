package com.naldana.activitysexample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    // Data
    private var scoreTeamA = 0
    private var scoreTeamB = 0

    // Views
    private lateinit var teamAScoreTextView: TextView
    private lateinit var teamBScoreTextView: TextView
    private lateinit var teamAAddButton: Button
    private lateinit var teamBAddButton: Button
    private lateinit var saveButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(TAG, "onCreate")
        bind()
        setupScores(savedInstanceState)
        addListeners()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(KEY_SCORE_TEAM_A, scoreTeamA)
        outState.putInt(KEY_SCORE_TEAM_B, scoreTeamB)
        Log.d(TAG, "onSaveInstance")
    }


    private fun addListeners() {
        teamAAddButton.setOnClickListener {
            scoreTeamA++
            updateVisualScore(teamAScoreTextView, scoreTeamA)
        }

        teamBAddButton.setOnClickListener {
            scoreTeamB++
            updateVisualScore(teamBScoreTextView, scoreTeamB)
        }

        saveButton.setOnClickListener {
            onSave()
        }
    }

    private fun onSave() {
        Log.d(TAG, "onSave")
        // Intent
        val intent = Intent(this,ScoreActivity::class.java)
        intent.putExtra(KEY_SCORE_TEAM_A,scoreTeamA)
        intent.putExtra(KEY_SCORE_TEAM_B,scoreTeamB)
        startActivity(intent)
    }

    private fun updateVisualScore(view: TextView, score: Int) {
        view.text = score.toString()
    }

    private fun setupScores(savedInstanceState: Bundle?) {
        savedInstanceState?.let { saveInstanceState ->
            scoreTeamA = saveInstanceState.getInt(KEY_SCORE_TEAM_A, 0)
            scoreTeamB = saveInstanceState.getInt(KEY_SCORE_TEAM_B, 0)
        }
        updateVisualScore(teamAScoreTextView, scoreTeamA)
        updateVisualScore(teamBScoreTextView, scoreTeamB)
    }

    private fun bind() {
        // Team A
        teamAScoreTextView = findViewById(R.id.score_team_a_text_view)
        teamAAddButton = findViewById(R.id.action_add_one_team_a)
        // Team B
        teamBScoreTextView = findViewById(R.id.score_team_b_text_view)
        teamBAddButton = findViewById(R.id.action_add_one_team_b)
        // Save
        saveButton = findViewById(R.id.action_save)
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "onRestart")
    }

    companion object {
        private val TAG = MainActivity::class.simpleName
        const val KEY_SCORE_TEAM_A = "ScoreTeamA"
        const val KEY_SCORE_TEAM_B = "ScoreTeamB"
    }
}