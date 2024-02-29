package com.example.pokedex.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pokedex.domain.model.Pokemon
import com.example.pokedex.domain.usecase.PokemonFormatUseCase
import com.example.pokedex.domain.usecase.PokemonRequestUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

private val errorPokemon = Pokemon("????",
    "MissingNo.",
    "https://static.wikia.nocookie.net/pokemonet/images/1/19/Missingno..png/revision/latest?cb=20130505210537&path-prefix=pt-br",
    List (1){ "????" })

private val scope = CoroutineScope( Dispatchers.IO )

class PokemonViewModel(private val pokemonRequestUseCase: PokemonRequestUseCase, private val pokemonFormatUseCase: PokemonFormatUseCase): ViewModel() {
    var pokemonLiveData= MutableLiveData<Pokemon>()

    fun getPokemonById(id:String){

        scope.launch{
            pokemonRequestUseCase.getPokemonById(id)
            .flowOn(Dispatchers.IO)

                .catch {
//                    Log.d(TAG, "Error in getPokemonById: "+it)
                    withContext(Dispatchers.Main){
                        pokemonLiveData.value = pokemonFormatUseCase.pokemonFormat(errorPokemon)
                    }

                }

                .collect {
//                    Log.d(TAG, "getPokemonById: ${it.nome}")
                    withContext(Dispatchers.Main){
                        pokemonLiveData.value = pokemonFormatUseCase.pokemonFormat(it)
                    }

                }

        }

    }



}