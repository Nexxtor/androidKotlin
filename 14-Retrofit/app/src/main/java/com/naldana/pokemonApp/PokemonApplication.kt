package com.naldana.pokemonApp

import android.app.Application
import com.naldana.pokemonApp.network.services.PokemonService
import com.naldana.pokemonApp.repositories.PokemonRepository

class PokemonApplication : Application() {
    private val pokemonService by lazy {
        PokemonService()
    }
    val pokemonRepository by lazy {
        PokemonRepository(pokemonService)
    }
}