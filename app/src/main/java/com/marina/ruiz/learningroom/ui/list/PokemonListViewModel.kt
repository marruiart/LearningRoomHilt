package com.marina.ruiz.learningroom.ui.list

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.marina.ruiz.learningroom.data.repository.Pokemon
import com.marina.ruiz.learningroom.data.repository.PokemonRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class PokemonListViewModel @Inject constructor(
    private val repository: PokemonRepository
) : ViewModel() {

    private val _pokemonList: MutableStateFlow<List<Pokemon>> = MutableStateFlow(listOf())
    val pokemonList: StateFlow<List<Pokemon>>
        get() = _pokemonList.asStateFlow()

    init {
        viewModelScope.launch {
            try {
                repository.refreshList()
            } catch (e: IOException) {
                Log.ERROR
            }
            viewModelScope.launch {
                repository.allPokemon.collect { // subscription
                    _pokemonList.value = it
                }
            }
        }
    }
}