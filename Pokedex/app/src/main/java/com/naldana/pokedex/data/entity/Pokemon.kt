package com.naldana.pokedex.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "pokemon_table")
data class Pokemon(
    @PrimaryKey
    var id: Int,
    var name: String,
    var height: Int,
    var weight: Int
)