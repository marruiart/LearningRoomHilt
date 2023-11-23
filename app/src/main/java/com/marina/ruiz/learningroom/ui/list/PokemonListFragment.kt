package com.marina.ruiz.learningroom.ui.list

import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.marina.ruiz.learningroom.databinding.FragmentPokemonListBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PokemonListFragment : Fragment() {
    private lateinit var binding: FragmentPokemonListBinding
    private val viewModel: PokemonListViewModel by viewModels()
}