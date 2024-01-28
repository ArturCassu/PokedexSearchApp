package com.example.pokedex.repository

import com.example.pokedex.model.Pokemon
import kotlinx.coroutines.flow.Flow

interface PokeRepository {

    suspend fun getPokemonById(id:String): Flow<Pokemon>

}