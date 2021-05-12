package com.naldana.pokedex.repository

import com.naldana.pokedex.data.dao.PokemonDao
import com.naldana.pokedex.network.PokeAPI
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class PokemonRepository(private val API: PokeAPI, private val pokemonDao: PokemonDao) {
    //  val API = PokeAPI.service

    /**
     * Busca un pokemon
     * @param key [String] id
     * @return [String] JSON con la información de pokemon
     */
    suspend fun search(key: String) = withContext(Dispatchers.IO) {
        val pokemon = API.service.search(key)
        pokemonDao.insert(pokemon)
        pokemonDao.search(key.toInt())
    }

}