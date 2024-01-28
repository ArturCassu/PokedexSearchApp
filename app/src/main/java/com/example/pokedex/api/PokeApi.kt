package com.example.pokedex.api

import com.example.pokedex.model.PokemonResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface PokeApi {

    @GET("pokemon/{pokemon}")
    suspend fun getPokemon(@Path("pokemon") pokemon: String): PokemonResponse

}