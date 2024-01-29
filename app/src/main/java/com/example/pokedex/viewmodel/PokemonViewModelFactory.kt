package com.example.pokedex.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.pokedex.usecase.PokemonUseCases

class PokemonViewModelFactory() : ViewModelProvider.Factory {

    private val pokemonUseCases = PokemonUseCases()
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PokemonViewModel::class.java)) {
            return PokemonViewModel(pokemonUseCases) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
