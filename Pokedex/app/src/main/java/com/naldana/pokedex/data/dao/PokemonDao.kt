package com.naldana.pokedex.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.naldana.pokedex.data.entity.Pokemon

@Dao
interface PokemonDao {

    @Insert
    suspend fun insert(pokemon: Pokemon)

    @Query("SELECT * FROM pokemon_table WHERE id = :key or name = :key")
    suspend fun search(key: String): Pokemon?

    @Query("SELECT * FROM pokemon_table")
    fun findAll(): LiveData<List<Pokemon>>

    @Update
    suspend fun update(pokemon: Pokemon)

    @Delete
    suspend fun delete(pokemon: Pokemon)

}