package com.example.pokedex.repository

import com.example.pokedex.model.Pokemon
import com.example.pokedex.util.RetrofitClient
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class PokeRepositoryImpl: PokeRepository {

    override suspend fun getPokemonById(id:String): Flow<Pokemon> = flow {
        val api = RetrofitClient.getService()
        val response = api.getPokemon(id)
        val pokemon = Pokemon(
            id = response.id,
            nome = response.name,
            spriteDefault = response.sprites.other.officialArtWork.frontDefault,
            types = (response.types).map {it.type.name}
        )
        emit(pokemon)
    }

}