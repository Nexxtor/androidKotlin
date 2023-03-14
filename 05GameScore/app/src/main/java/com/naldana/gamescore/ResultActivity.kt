package com.naldana.gamescore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        if( intent != null ){
            intent.extras?.apply {
                val scoreTeamA = getInt(MainActivity.TEAM_A_SCORE)
                val scoreTeamB = getInt(MainActivity.TEAM_B_SCORE)
                findViewById<TextView>(R.id.display_result_text_view).apply {
                    text = getString(R.string.text_result, scoreTeamA, scoreTeamB)
                }
            }
        }
    }

    companion object {
        const val TAG = "com.naldana.gamescore.ResultActivity"
    }
}