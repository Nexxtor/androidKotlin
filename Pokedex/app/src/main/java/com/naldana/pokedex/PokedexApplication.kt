package com.naldana.pokedex

import android.app.Application
import com.naldana.pokedex.data.PokedexDatabase
import com.naldana.pokedex.network.PokeAPI
import com.naldana.pokedex.repository.PokemonRepository

class PokedexApplication : Application() {
    private val database by lazy { PokedexDatabase.getDatabase(this) }
    val pokemonRepository by lazy {
        val pokemonDao = database.pokemonDao()
        PokemonRepository(PokeAPI, pokemonDao)
    }
}