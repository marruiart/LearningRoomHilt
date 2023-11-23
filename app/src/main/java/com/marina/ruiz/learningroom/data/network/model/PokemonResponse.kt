package com.marina.ruiz.learningroom.data.network.model

import com.google.gson.annotations.SerializedName

data class PokemonListResponse(
    val count: Int,
    val next: String?,
    val previous: String?,
    val results: List<PokemonListItem>
)

data class PokemonListItem(
    val name: String
)

data class PokemonDetailResponse(
    val id: Int,
    val name: String,
    val weight: Int,
    val height: Int,
    val sprites: PokemonSpritesResponse,
    val types: List<PokemonTypeResponse>
) {
    fun asApiModel(): PokemonApiModel {
        return PokemonApiModel(
            id,
            name,
            weight,
            height,
            sprites.frontDefault,
            types[0].type.name,
            if (types.size == 2) types[1].type.name else null
        )
    }
}

data class PokemonSpritesResponse(
    @SerializedName("front_default")
    val frontDefault: String?
)

data class PokemonTypeResponse(
    val type: PokemonNameTypeResponse
)

data class PokemonNameTypeResponse(
    val name: String
)