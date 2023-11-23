package com.marina.ruiz.learningroom.data.network.model

import com.marina.ruiz.learningroom.data.local.PokemonEntity

data class PokemonApiModel(
    val id: Int,
    val name: String,
    val weight: Int,
    val height: Int,
    val frontDefault: String?,
    val primType: String,
    val secType: String?
) {
    fun asPokemonEntity(): PokemonEntity {
        return PokemonEntity(
            name,
            id,
            weight,
            height,
            frontDefault,
            primType,
            secType
        )
    }
}

fun List<PokemonApiModel>.asEntityModelList(): List<PokemonEntity> {
    return this.map {
        it.asPokemonEntity()
    }
}