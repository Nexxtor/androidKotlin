package com.naldana.pokemonApp.network

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.naldana.pokemonApp.models.Pokemon
import com.naldana.pokemonApp.network.services.PokemonService
import retrofit2.HttpException
import java.io.IOException

class PokemonPagingSource(private val pokemonService: PokemonService) :
    PagingSource<Int, Pokemon>() {

    override fun getRefreshKey(state: PagingState<Int, Pokemon>): Int? {
        val pageSize = state.config.pageSize
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(pageSize) ?: anchorPage?.nextKey?.minus(pageSize)
        }
    }

    override suspend fun load(params: LoadParams<Int>):
            LoadResult<Int, Pokemon> {
        return try {
            val nextPage = params.key ?: 0
            val pageSize = params.loadSize
            val pokemonsResult = pokemonService
                .getPokemons(pageSize, nextPage)
            LoadResult.Page(
                data = pokemonsResult.results,
                nextKey = if (pokemonsResult.next != null) nextPage + pageSize else null,
                prevKey = if (pokemonsResult.previous != null) nextPage - pageSize else null
            )
        } catch (e: IOException) {
            LoadResult.Error(e)
        } catch (e: HttpException) {
            LoadResult.Error(e)
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}