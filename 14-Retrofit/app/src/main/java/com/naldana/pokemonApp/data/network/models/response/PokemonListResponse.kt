package com.naldana.pokemonApp.data.network.models.response

import com.naldana.pokemonApp.data.db.models.Pokemon

data class PokemonListResponse(
    val count: String,
    var next: String?,
    var previous: String?,
    val results: List<Pokemon>
)
