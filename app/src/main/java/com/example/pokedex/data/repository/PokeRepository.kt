package com.example.pokedex.data.repository

import com.example.pokedex.domain.usecase.model.Pokemon
import kotlinx.coroutines.flow.Flow

interface PokeRepository {

    suspend fun getPokemonById(id:String): Flow<Pokemon>

}