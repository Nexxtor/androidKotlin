package com.naldana.pokemonApp

import android.app.Application
import com.naldana.pokemonApp.data.db.PokemonAppDatabase
import com.naldana.pokemonApp.data.network.services.PokemonService
import com.naldana.pokemonApp.repositories.PokemonRepository

class PokemonApplication : Application() {
    private val database: PokemonAppDatabase by lazy {
        PokemonAppDatabase.getInstance(this)
    }
    private val pokemonService by lazy {
        PokemonService()
    }
    val pokemonRepository by lazy {
        PokemonRepository(database, pokemonService)
    }
}