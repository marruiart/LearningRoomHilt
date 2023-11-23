package com.marina.ruiz.learningroom.data.network

import com.marina.ruiz.learningroom.data.network.model.PokemonApiModel

class PokemonNetworkRepository(private val service: PokemonService) {

    suspend fun getAll(): List<PokemonApiModel> {
        val simpleList = service.api.getAll()
        return simpleList.results.map {
            pokemonListItemResponse ->
                service.api.getDetail(pokemonListItemResponse.name).asApiModel()
        }
    }
}