package com.naldana.pokedex.data.dao

import androidx.room.*
import com.naldana.pokedex.data.entity.Pokemon

@Dao
interface PokemonDao {

    @Insert
    suspend fun insert(pokemon: Pokemon)

    @Query("SELECT * FROM pokemon_table WHERE id = :id")
    suspend fun search(id: Int): Pokemon

    @Query("SELECT * FROM pokemon_table WHERE name like :name")
    suspend fun search(name: String): Pokemon

    @Update
    fun update(pokemon: Pokemon)

    @Delete
    fun delete(pokemon: Pokemon)
}