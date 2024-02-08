package com.example.pokedex.util

import com.example.pokedex.data.api.PokeApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class RetrofitClient {


    companion object{
        private const val baseUrl = "https://pokeapi.co/api/v2/"
        fun getService(): PokeApi {
            return Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(PokeApi::class.java)
        }
    }


}