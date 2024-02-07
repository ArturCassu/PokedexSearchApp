package com.example.pokedex.data.repository

import com.example.pokedex.data.api.PokeApi
import com.example.pokedex.domain.model.Pokemon
import com.example.pokedex.util.RetrofitClient
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class PokeRepositoryImpl(private val api:PokeApi): PokeRepository {

    override suspend fun getPokemonById(id:String): Flow<Pokemon> = flow {
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