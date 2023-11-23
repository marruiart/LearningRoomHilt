package com.marina.ruiz.learningroom.data.network

import com.marina.ruiz.learningroom.data.network.model.PokemonApiModel
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PokemonNetworkRepository @Inject constructor(private val service: PokemonService) {

    suspend fun getAll(): List<PokemonApiModel> {
        val simpleList = service.api.getAll()
        return simpleList.results.map {
            pokemonListItemResponse ->
                service.api.getDetail(pokemonListItemResponse.name).asApiModel()
        }
    }
}