package com.naldana.pokedex.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.naldana.pokedex.data.entity.Pokemon
import com.naldana.pokedex.data.entity.PokemonType
import com.naldana.pokedex.data.entity.PokemonWhitType

@Dao
interface PokemonDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(pokemon: Pokemon)

    @Update
    fun update(pokemon: Pokemon)

    @Query("SELECT * FROM pokemons WHERE name like :key or id = :key")
    suspend fun search(key: String): Pokemon?

    @Query("SELECT * FROM pokemons")
    fun findAll(): LiveData<List<Pokemon>>


    @Insert
    suspend fun insertTypesOfPokemon(types: List<PokemonType>)

    @Transaction
    suspend fun insertPokemonWhitType(pokemon: Pokemon) {
        insert(pokemon) // Guarda la infomacion base del pokemon
        val pokemonTypes =
            pokemon.types.map { // Mapea los tipos y asigna el pokemon id para relacionarlo en la base
                it.idPokemon = pokemon.id
                it
            }
        insertTypesOfPokemon(pokemonTypes)
    }

    @Transaction
    @Query("SELECT * FROM pokemons")
    fun getPokemonsWhitType(): LiveData<List<PokemonWhitType>>

    @Delete
    fun delete(pokemon: Pokemon)
}