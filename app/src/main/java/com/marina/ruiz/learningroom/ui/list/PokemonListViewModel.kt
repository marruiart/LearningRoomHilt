package com.marina.ruiz.learningroom.ui.list

import androidx.lifecycle.ViewModel
import com.marina.ruiz.learningroom.data.repository.PokemonRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PokemonListViewModel @Inject constructor(
    private val repository: PokemonRepository
) : ViewModel() {

}