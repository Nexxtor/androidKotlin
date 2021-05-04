package com.naldana.pokedex.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val POKE_API_BASE_URL = "https://pokeapi.co/api/v2/"

private val interceptor = HttpLoggingInterceptor().apply {
    level = HttpLoggingInterceptor.Level.BODY
}
private val client = OkHttpClient.Builder()
    .addInterceptor(interceptor).build()

private val retrofit = Retrofit.Builder()
    .baseUrl(POKE_API_BASE_URL)
    .addConverterFactory(GsonConverterFactory.create())
    .client(client)
    .build()

object PokeAPI {
    val service by lazy {
        retrofit.create(PokeService::class.java)
    }
}