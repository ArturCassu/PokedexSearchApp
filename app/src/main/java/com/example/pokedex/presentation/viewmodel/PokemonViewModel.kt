package com.example.pokedex.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pokedex.data.api.PokeApi
import com.example.pokedex.domain.model.Pokemon
import com.example.pokedex.domain.usecase.PokemonUseCases

class PokemonViewModel(private val pokemonUseCases: PokemonUseCases): ViewModel() {
    var pokemonLiveData= MutableLiveData<Pokemon>()

    fun getPokemonById(id:String){

        pokemonUseCases.getPokemonById(id){response ->
            pokemonLiveData.value = pokemonUseCases.pokemonFormat(response)
        }

    }



}