package com.marina.ruiz.learningroom.data.repository

data class Pokemon(
    val name: String,
    val weight: Int,
    val height: Int,
    val frontDefault: String?,
    val primType: String,
    val secType: String?
)
