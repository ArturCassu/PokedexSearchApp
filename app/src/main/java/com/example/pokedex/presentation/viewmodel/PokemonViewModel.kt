package com.example.pokedex.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pokedex.domain.model.Pokemon
import com.example.pokedex.domain.usecase.PokemonFormatUseCase
import com.example.pokedex.domain.usecase.PokemonRequestUseCase

class PokemonViewModel(private val pokemonRequestUseCase: PokemonRequestUseCase, private val pokemonFormatUseCase: PokemonFormatUseCase): ViewModel() {
    var pokemonLiveData= MutableLiveData<Pokemon>()

    fun getPokemonById(id:String){

        pokemonRequestUseCase.getPokemonById(id){ response ->
            pokemonLiveData.value = pokemonFormatUseCase.pokemonFormat(response)
        }

    }



}