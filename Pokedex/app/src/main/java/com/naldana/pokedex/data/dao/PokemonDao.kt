package com.naldana.pokedex.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.naldana.pokedex.data.entity.Pokemon

@Dao
interface PokemonDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(pokemon: Pokemon)

    @Update
    fun update(pokemon: Pokemon)

    @Query("SELECT * FROM pokemon_table WHERE name like :key or id = :key")
    suspend fun search(key: String): Pokemon?

    @Query("SELECT * FROM pokemon_table")
    fun findAll(): LiveData<List<Pokemon>>

    @Delete
    fun delete(pokemon: Pokemon)
}