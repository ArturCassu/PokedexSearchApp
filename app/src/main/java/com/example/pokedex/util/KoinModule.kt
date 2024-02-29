package com.example.pokedex.util

import com.example.pokedex.data.repository.PokeRepositoryImpl
import com.example.pokedex.domain.usecase.PokemonFormatUseCase
import com.example.pokedex.domain.usecase.PokemonRequestUseCase
import com.example.pokedex.viewmodel.PokemonViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

class ModuleProvider {
    fun getModule() = module{
        single { RetrofitClient.getService() }
        single { PokeRepositoryImpl( get() ) }
        single<PokemonRequestUseCase> { PokemonRequestUseCase( get() ) }
        single<PokemonFormatUseCase> { PokemonFormatUseCase() }
        viewModel{PokemonViewModel( get(), get() )}
    }
}

