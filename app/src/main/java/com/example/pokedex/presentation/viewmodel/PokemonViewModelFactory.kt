package com.example.pokedex.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.pokedex.domain.usecase.PokemonFormatUseCase
import com.example.pokedex.domain.usecase.PokemonRequestUseCase
import com.example.pokedex.util.RetrofitClient

class PokemonViewModelFactory() : ViewModelProvider.Factory {

    private val pokemonRequestUseCase = PokemonRequestUseCase(RetrofitClient.getService())
    private val pokemonFormatUseCase = PokemonFormatUseCase()
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PokemonViewModel::class.java)) {
            return PokemonViewModel(pokemonRequestUseCase, pokemonFormatUseCase) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
