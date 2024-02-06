package com.example.pokedex.domain.usecase

import android.util.Log
import com.example.pokedex.domain.model.Pokemon
import com.example.pokedex.data.repository.PokeRepositoryImpl
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.withContext


class PokemonUseCases {

    private val TAG = "Api Requests"
    private val scope = CoroutineScope( Dispatchers.IO )


    fun getPokemonById(id: String, callback: (Pokemon) -> Unit) {
        Log.d(TAG, "getPokemonById")
        scope.launch{
            PokeRepositoryImpl().getPokemonById(id)
                .flowOn(Dispatchers.IO)
                .catch {
                    Log.d(TAG, "Error in getPokemonById")
                    withContext(Dispatchers.Main){
                        callback(
                            Pokemon(
                            "????",
                            "MissingNo.",
                            "https://static.wikia.nocookie.net/pokemonet/images/1/19/Missingno..png/revision/latest?cb=20130505210537&path-prefix=pt-br",
                            List (1){ "????" }
                            )
                        )
                    }
                }
                .collect {
                    Log.d(TAG, "getPokemonById: ${it.nome}")
                    withContext(Dispatchers.Main){
                        callback(it)
                    }
                }

        }
        Log.d(TAG, "getPokemonById Success")
    }

}