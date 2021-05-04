package com.naldana.pokedex.repository

import com.naldana.pokedex.network.PokeAPI

class PokemonRepository {
    suspend fun getPokemon(key: String) = PokeAPI.service.getPokemon(key)
}