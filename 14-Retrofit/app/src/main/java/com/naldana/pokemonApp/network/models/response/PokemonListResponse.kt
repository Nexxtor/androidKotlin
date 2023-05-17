package com.naldana.pokemonApp.network.models.response

import com.naldana.pokemonApp.models.Pokemon

data class PokemonListResponse(
    val count: String,
    var next: String?,
    var previous: String?,
    val results: List<Pokemon>
)
