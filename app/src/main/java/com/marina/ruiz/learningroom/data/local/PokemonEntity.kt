package com.marina.ruiz.learningroom.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.marina.ruiz.learningroom.data.repository.Pokemon

@Entity(tableName = "pokemon")
data class PokemonEntity(
    @PrimaryKey val name: String,
    val id: Int?,
    val weight: Int,
    val height: Int,
    val frontDefault: String?,
    val primType: String,
    val secType: String?
) {
    fun asPokemon(): Pokemon {
        return Pokemon(
            name,
            weight,
            height,
            frontDefault,
            primType,
            secType
        )
    }
}

fun List<PokemonEntity>.asListPokemon(): List<Pokemon> {
    // this is referred to List<PokemonEntity>
    return this.map {
        it.asPokemon()
    }
}
