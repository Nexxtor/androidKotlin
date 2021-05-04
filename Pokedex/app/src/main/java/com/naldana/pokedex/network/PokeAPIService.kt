package com.naldana.pokedex.network

import androidx.lifecycle.LiveData
import com.naldana.pokedex.data.Pokemon
import retrofit2.http.GET
import retrofit2.http.Path

interface PokeAPIService {
    @GET("pokemon/{key}")
    suspend fun getPokemon(@Path("key") key: String): Pokemon
}