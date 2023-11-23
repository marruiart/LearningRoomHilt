package com.marina.ruiz.learningroom.data.network

import com.marina.ruiz.learningroom.data.network.model.PokemonDetailResponse
import com.marina.ruiz.learningroom.data.network.model.PokemonListResponse
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface PokemonApi {
    @GET("pokemon")
    suspend fun getAll(): PokemonListResponse

    @GET("pokemon/{name}")
    suspend fun getDetail(@Path("name") name: String): PokemonDetailResponse

    @GET("pokemon/{id}")
    suspend fun getDetail(@Path("id") id: Int): PokemonDetailResponse
}

class PokemonService() {
    // Instantiate retrofit
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://pokeapi.co/api/v2/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    // Create API
    val api: PokemonApi = retrofit.create(PokemonApi::class.java)
}