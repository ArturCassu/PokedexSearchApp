package com.example.pokedex.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.pokedex.domain.usecase.PokemonUseCases
import com.example.pokedex.util.RetrofitClient

class PokemonViewModelFactory() : ViewModelProvider.Factory {

    private val pokemonUseCases = PokemonUseCases(RetrofitClient.getService())
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PokemonViewModel::class.java)) {
            return PokemonViewModel(pokemonUseCases) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
