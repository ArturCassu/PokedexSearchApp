package com.example.pokedex.domain.usecase

import com.example.pokedex.data.api.PokeApi
import com.example.pokedex.data.repository.PokeRepositoryImpl
import com.example.pokedex.domain.model.Pokemon
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class PokemonRequestUseCase(private val api: PokeApi) {

    private val TAG = "Api Requests"
    private val scope = CoroutineScope( Dispatchers.IO )
    private val errorPokemon = Pokemon("????",
                                        "MissingNo.",
                                        "https://static.wikia.nocookie.net/pokemonet/images/1/19/Missingno..png/revision/latest?cb=20130505210537&path-prefix=pt-br",
                                        List (1){ "????" })

    fun getPokemonById(id: String):Pokemon? {
//        Log.d(TAG, "getPokemonById")
        var pokemonRetorno: Pokemon? = null
        scope.launch{
            PokeRepositoryImpl(api).getPokemonById(id)
                .flowOn(Dispatchers.IO)
                .catch {
//                    Log.d(TAG, "Error in getPokemonById: "+it)
                    withContext(Dispatchers.Main){
                        pokemonRetorno = (errorPokemon)
                    }
                }
                .collect {
//                    Log.d(TAG, "getPokemonById: ${it.nome}")
                    withContext(Dispatchers.Main){
                        pokemonRetorno = (it)
                    }
                }

        }
//        Log.d(TAG, "getPokemonById Fineshed")
        return pokemonRetorno
    }
}