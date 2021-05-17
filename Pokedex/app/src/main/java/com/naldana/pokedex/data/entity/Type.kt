package com.naldana.pokedex.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "types")
data class Type(
    @PrimaryKey
    var name: String
) {
    var url: String = ""
}
