package com.naldana.pokedex.repository

import com.naldana.pokedex.network.PokeAPI

class PokemonRepository {
    val API = PokeAPI.service

    /**
     * Busca un pokemon
     * @param key [String] Nombre o Numero de Pokemon
     * @return [String] JSON con la información de pokemon
     */
    suspend fun search(key: String) = API.search(key)
}