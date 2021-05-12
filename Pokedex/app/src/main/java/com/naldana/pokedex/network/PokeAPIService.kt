package com.naldana.pokedex.network

import com.naldana.pokedex.data.entity.Pokemon
import retrofit2.http.GET
import retrofit2.http.Path

interface PokeAPIService {
    @GET("pokemon/{key}")
    suspend fun getPokemon(@Path("key") key: String): Pokemon
}