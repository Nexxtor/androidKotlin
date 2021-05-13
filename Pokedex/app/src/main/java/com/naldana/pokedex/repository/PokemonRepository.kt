package com.naldana.pokedex.repository

import com.naldana.pokedex.data.dao.PokemonDao
import com.naldana.pokedex.network.PokeAPI
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class PokemonRepository(private val API: PokeAPI, private val pokemonDao: PokemonDao) {
    /**
     * Busca un pokemon
     * @param key [String] id
     * @return [String] JSON con la información de pokemon
     */
    suspend fun search(key: String) = withContext(Dispatchers.IO) {
        var pokemon = pokemonDao.search(key)
        if (pokemon == null) {
            pokemon = API.service.search(key)
            pokemonDao.insert(pokemon)
        }
        pokemon
    }

    fun findAll() = pokemonDao.findAll()

}