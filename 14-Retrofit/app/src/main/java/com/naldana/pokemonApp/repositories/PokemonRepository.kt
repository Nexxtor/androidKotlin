package com.naldana.pokemonApp.repositories

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.naldana.pokemonApp.data.PokemonMediator
import com.naldana.pokemonApp.data.db.PokemonAppDatabase
import com.naldana.pokemonApp.data.network.PokemonPagingSource
import com.naldana.pokemonApp.data.network.services.PokemonService

class PokemonRepository(
    private val database: PokemonAppDatabase,
    private val pokemonService: PokemonService
) {
    private val pokemonDao = database.pokemonDao()

    @ExperimentalPagingApi
    fun getPokemonPage(pageSize: Int) = Pager(
        config = PagingConfig(
            pageSize = pageSize,
            prefetchDistance = (0.10 * pageSize).toInt()
        ),
        remoteMediator = PokemonMediator(database, pokemonService)
    ) {
        pokemonDao.pagingSource()
    }.flow
}