package com.naldana.pokemonApp.data.db.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

/**
 * Pokemon data
 */
@Entity(tableName = "pokemons")
data class Pokemon(
    /**
     * Official name of pokemon
     */
    @PrimaryKey var name: String,
    /**
     * URL to front image view of pokemon
     */
    @SerializedName("url") var image: String
)
