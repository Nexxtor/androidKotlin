package com.naldana.pokedex.repository

import com.naldana.pokedex.data.dao.PokemonDao
import com.naldana.pokedex.network.PokeAPI
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class PokemonRepository(
    private val api: PokeAPI,
    private val pokemonDao: PokemonDao
) {

    suspend fun getPokemon(key: String) = withContext(Dispatchers.IO) {
        var pokemon = pokemonDao.search(key)
        if (pokemon == null) {
            pokemon = api.service.getPokemon(key)
            pokemonDao.insertPokemonWhitType(pokemon)
        }
        pokemon
    }

    fun findAll() = pokemonDao.getPokemonsWhitType()
}