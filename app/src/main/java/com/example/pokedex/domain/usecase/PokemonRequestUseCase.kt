package com.example.pokedex.domain.usecase

import com.example.pokedex.data.repository.PokeRepositoryImpl
import com.example.pokedex.domain.model.Pokemon
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow


class PokemonRequestUseCase(private val pokeRepositoryImpl: PokeRepositoryImpl) {

    private val TAG = "Api Requests"
    private val scope = CoroutineScope( Dispatchers.IO )
    private val errorPokemon = Pokemon("????",
                                        "MissingNo.",
                                        "https://static.wikia.nocookie.net/pokemonet/images/1/19/Missingno..png/revision/latest?cb=20130505210537&path-prefix=pt-br",
                                        List (1){ "????" })

    suspend fun getPokemonById(id: String): Flow<Pokemon> {
//        Log.d(TAG, "getPokemonById")
//        var pokemonRetorno: Pokemon? = null
//        scope.launch{
        return pokeRepositoryImpl.getPokemonById(id)
//                .flowOn(Dispatchers.IO)
//
//                .catch {
//                    Log.d(TAG, "Error in getPokemonById: "+it)
//                    withContext(Dispatchers.Main){
//                        pokemonRetorno = (errorPokemon)
//                    }
//
//                }
//
//                .collect {
//                    Log.d(TAG, "getPokemonById: ${it.nome}")
//                    withContext(Dispatchers.Main){
//                        pokemonRetorno = (it)
//                    }
//
//                }
//
//        }
//        Log.d(TAG, "getPokemonById Fineshed")
//        return pokemonRetorno
    }
}