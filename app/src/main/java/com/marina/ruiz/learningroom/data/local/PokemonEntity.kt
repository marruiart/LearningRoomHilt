package com.marina.ruiz.learningroom.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "pokemon")
data class PokemonEntity(
    @PrimaryKey val name: String,
    val id: Int?,
    val weight: Int,
    val height: Int
)
