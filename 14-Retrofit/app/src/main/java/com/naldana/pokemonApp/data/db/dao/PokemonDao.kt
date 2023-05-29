package com.naldana.pokemonApp.data.db.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.naldana.pokemonApp.data.db.models.Pokemon

@Dao
interface PokemonDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(pokemons: List<Pokemon>)

    @Query("SELECT * FROM pokemons")
    fun pagingSource(): PagingSource<Int, Pokemon>

    @Query("DELETE FROM pokemons")
    suspend fun clearAll()
}