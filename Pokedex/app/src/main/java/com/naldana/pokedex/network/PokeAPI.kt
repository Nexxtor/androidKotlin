package com.naldana.pokedex.network

import com.google.gson.Gson
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val POKE_API_BASE_URL = "https://pokeapi.co/api/v2/"

private var retrofit = Retrofit.Builder()
    .baseUrl(POKE_API_BASE_URL)
    .addConverterFactory(GsonConverterFactory.create())
    .build()

object PokeAPI {
    val service = retrofit.create(PokeAPIService::class.java)
}



