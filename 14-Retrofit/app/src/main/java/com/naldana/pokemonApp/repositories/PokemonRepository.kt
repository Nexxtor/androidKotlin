package com.naldana.pokemonApp.repositories

import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.naldana.pokemonApp.network.PokemonPagingSource
import com.naldana.pokemonApp.network.services.PokemonService

class PokemonRepository(val pokemonService: PokemonService) {
    suspend fun getPokemons(limit: Int, offset: Int) =
        pokemonService.getPokemons(limit, offset)

    fun getPokemonPage(pageSize: Int) = Pager(
        PagingConfig(pageSize)
    ) {
        PokemonPagingSource(pokemonService)
    }.flow
}