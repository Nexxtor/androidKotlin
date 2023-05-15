package com.example.laboratorio05.ui.movie

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.laboratorio05.R
import com.example.laboratorio05.data.model.MovieModel

class NewMovieFragment : Fragment() {

    private val movieViewModel: MovieViewModel by activityViewModels {
        MovieViewModel.Factory
    }

    private lateinit var nameEditText: EditText
    private lateinit var categoryEditText: EditText
    private lateinit var descriptionEditText: EditText
    private lateinit var qualificationEditText: EditText
    private lateinit var summitButton: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_new_movie, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bind()
        summitButton.setOnClickListener {
            addMovie()
        }
    }

    private fun bind() {
        nameEditText = view?.findViewById(R.id.name_edit_text) !!
        categoryEditText = view?.findViewById(R.id.category_edit_text) !!
        descriptionEditText = view?.findViewById(R.id.description_edit_text) !!
        qualificationEditText = view?.findViewById(R.id.qualification_edit_text) !!
        summitButton = view?.findViewById(R.id.submit_button) !!
    }

    // add a movie using the view model
    private fun addMovie() {

        val name = nameEditText.text.toString()
        val category = categoryEditText.text.toString()
        val description = descriptionEditText.text.toString()
        val qualification = qualificationEditText.text.toString()

        val movie = MovieModel(name, category, description, qualification)

        movieViewModel.addMovies(movie)

        Log.d("NewMovieFragment", movieViewModel.getMovies().toString())

        findNavController().popBackStack()
    }



}