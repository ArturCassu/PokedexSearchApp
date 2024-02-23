package com.example.pokedex.util

import com.example.pokedex.domain.usecase.PokemonFormatUseCase
import com.example.pokedex.domain.usecase.PokemonRequestUseCase
import com.example.pokedex.viewmodel.PokemonViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

class ModuleProvider {
    fun getModule() = module{
        single<PokemonRequestUseCase> { PokemonRequestUseCase(RetrofitClient.getService()) }
        single<PokemonFormatUseCase> { PokemonFormatUseCase() }
        viewModel{PokemonViewModel( get(), get() )}
    }
}

