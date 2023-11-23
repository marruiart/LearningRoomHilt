package com.marina.ruiz.learningroom.data.repository

import com.marina.ruiz.learningroom.data.local.PokemonLocalRepository
import com.marina.ruiz.learningroom.data.local.asListPokemon
import com.marina.ruiz.learningroom.data.network.PokemonNetworkRepository
import com.marina.ruiz.learningroom.data.network.model.asEntityModelList
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PokemonRepository @Inject constructor(
    // Dependency injection
    private val localRepository: PokemonLocalRepository,
    private val networkRepository: PokemonNetworkRepository
) {

    // Expose data operations
    val allPokemon: Flow<List<Pokemon>>
        get() {
            // offline first
            return localRepository.allPokemon.map { listPokemonEntity ->
                listPokemonEntity.asListPokemon()
            }
        }

    suspend fun refreshList() = withContext(Dispatchers.IO) {
        // SCOPE: suspendable code -> executed asynchronously in a coroutine.
        // Dispatchers.IO is a special thread for network operations
        val pokemonApiModelList = networkRepository.getAll()
        localRepository.insert(pokemonApiModelList.asEntityModelList())
    }
}