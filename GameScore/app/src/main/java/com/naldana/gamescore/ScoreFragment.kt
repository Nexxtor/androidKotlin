package com.naldana.gamescore

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment

private const val TEAM_NAME = "TEAM_NAME"
private const val SCORE = "SCORE"

class ScoreFragment : Fragment() {

    private var teamName = "No Name"
    private var teamScore = 0
    private var scoreListener: OnScorePlusListener? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnScorePlusListener) {
            scoreListener = context
        } else {
            throw Exception("Require a implementation of OnScorePlusListener")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            teamName = it.getString(TEAM_NAME) ?: teamName
            teamScore = it.getInt(SCORE)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.score_fragment, container, false)

        val teamNameTextView = view.findViewById<TextView>(R.id.text_view_team_name)
        val scoreTextView = view.findViewById<TextView>(R.id.text_view_score_team)

        teamNameTextView.text = teamName
        scoreTextView.text = teamScore.toString()

        val addOne = view.findViewById<Button>(R.id.action_plus_one_team)
        addOne.setOnClickListener {
            teamScore++
            scoreTextView.text = teamScore.toString()
            scoreListener?.onPlus(teamName, teamScore)
        }
        return view
    }

    companion object {
        fun newInstance(teamName: String, score: Int) = ScoreFragment().apply {
            arguments = Bundle().apply {
                putString(TEAM_NAME, teamName)
                putInt(SCORE, score)
            }
        }
    }

    interface OnScorePlusListener {
        fun onPlus(teamName: String, newScore: Int)
    }
}