package com.example.laboratorio05

import android.app.Application
import com.example.laboratorio05.data.movies
import com.example.laboratorio05.repositories.MovieRepository

class MovieReviewerApplication : Application() {
    val movieRepository: MovieRepository by lazy {
        MovieRepository(movies)
    }
}