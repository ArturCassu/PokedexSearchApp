package com.example.pokedex.data.api

import com.example.pokedex.domain.model.PokemonResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface PokeApi {

    @GET("pokemon/{pokemon}")
    suspend fun getPokemon(@Path("pokemon") pokemon: String): PokemonResponse

}