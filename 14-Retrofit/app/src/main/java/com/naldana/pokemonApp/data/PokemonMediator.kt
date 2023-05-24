package com.naldana.pokemonApp.data

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.room.withTransaction
import com.naldana.pokemonApp.data.db.PokemonAppDatabase
import com.naldana.pokemonApp.data.db.models.Pokemon
import com.naldana.pokemonApp.data.db.models.RemoteKey
import com.naldana.pokemonApp.data.network.services.PokemonService
import retrofit2.HttpException
import java.io.IOException
import java.util.concurrent.TimeUnit

@OptIn(ExperimentalPagingApi::class)
class PokemonMediator(
    private val database: PokemonAppDatabase,
    private val pokemonService: PokemonService
) : RemoteMediator<Int, Pokemon>() {

    private var remoteKeyDao = database.remoteKeyDao()
    private var pokemonDao = database.pokemonDao()

    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, Pokemon>
    ): MediatorResult {
        try {
            // offset
            val loadKey = when (loadType) {
                LoadType.REFRESH -> 0
                LoadType.PREPEND ->
                    return MediatorResult.Success(endOfPaginationReached = true)
                LoadType.APPEND -> {
                    val remoteKey = database.withTransaction {
                        remoteKeyDao.remoteKeyByQuery("all")
                    }
                    if (remoteKey.nextKey == null) {
                        return MediatorResult.Success(
                            endOfPaginationReached = true
                        )
                    }
                    remoteKey.nextKey
                }
            }

            val response = pokemonService.getPokemons(
                state.config.pageSize,
                loadKey
            )

            database.withTransaction {
                if (loadType == LoadType.REFRESH) {
                    pokemonDao.clearAll()
                    remoteKeyDao.remoteKeyByQuery("all")
                }

                pokemonDao.insertAll(response.results)
                remoteKeyDao.insertOrReplace(
                    RemoteKey("all", getOffset(response.next))
                )
            }

            return MediatorResult.Success(
                endOfPaginationReached = response.next == null
            )

        } catch (e: HttpException) {
            return MediatorResult.Error(e)
        } catch (e: IOException) {
            return MediatorResult.Error(e)
        }
    }


    private fun getOffset(nextUrl: String?): Int? {
        val url = nextUrl ?: return null
        val pattern = Regex(".+offset=(\\d+).*").find(url)!!
        val (offset) = pattern.destructured
        return offset.toInt()
    }
}