package com.naldana.pokedex.data.entity

import androidx.room.Embedded
import androidx.room.Relation

data class PokemonWhitType(
    @Embedded val pokemon: Pokemon,
    @Relation(
        parentColumn = "id",
        entityColumn = "idPokemon"
    )
    val types: List<PokemonType>
)