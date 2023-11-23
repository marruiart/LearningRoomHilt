package com.marina.ruiz.learningroom.data.local

import androidx.annotation.WorkerThread
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PokemonLocalRepository @Inject constructor(private val pokemonDao: PokemonDao) {

    val allPokemon: Flow<List<PokemonEntity>> = pokemonDao.getAllPokemon()

    @WorkerThread
    suspend fun insert(listPokemonEntity: List<PokemonEntity>) =
        pokemonDao.createPokemon(listPokemonEntity)

    @WorkerThread
    suspend fun insert(pokemonEntity: PokemonEntity) = pokemonDao.createPokemon(pokemonEntity)
}