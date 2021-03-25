package com.naldana.gamescore

import android.os.Bundle
import android.util.Log
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

    companion object {
        const val TEAM_A = "TEAM_A"
        const val TEAM_B = "TEAM_B"
        val TAG  = MainActivity::class.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity_layout)
        bind()
        savedInstanceState?.let {
            scoreTeamA = it.getInt(TEAM_A, 0)
            scoreTeamB = it.getInt(TEAM_B, 0)
        }
        handlerTeamA(0)
        handlerTeamB(0)
        Log.d(TAG,"onCreate")
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG,"onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG,"onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG,"onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG,"onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG,"onDestroy")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG,"onRestart")
    }
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(TEAM_A, scoreTeamA)
        outState.putInt(TEAM_B, scoreTeamB)
        Log.d(TAG,"onSaveInstanceState")

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
            R.id.action_plus_team_a -> handlerTeamA(1)
            R.id.action_plus_team_b -> handlerTeamB(1)
        }
    }

    /**
     * Para agregar los eventos desde codigo fuente
     */
    private fun addEvenListeners() {
        addScoreTeamA.setOnClickListener {
            handlerTeamA(1)
        }
        addScoreTeamB.setOnClickListener {
            handlerTeamB(1)
        }
    }

    private fun handlerTeamA(points: Int) {
        scoreTeamA += points
        scoreTeamATextView.text = scoreTeamA.toString()
    }

    private fun handlerTeamB(points: Int) {
        scoreTeamB += points
        scoreTeamBTextView.text = scoreTeamB.toString()
    }
}