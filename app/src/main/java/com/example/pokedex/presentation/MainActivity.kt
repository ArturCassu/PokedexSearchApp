package com.example.pokedex.presentation


import com.example.pokedex.viewmodel.PokemonViewModelFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.pokedex.R
import com.example.pokedex.databinding.ActivityMainBinding
import com.example.pokedex.domain.model.Pokemon
import com.example.pokedex.viewmodel.PokemonViewModel
import kotlin.random.Random

abstract class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val numberOfPokemon = 1025

    private lateinit var viewModel: PokemonViewModel

    private lateinit var botaoPesquisaPoke: Button
    private lateinit var botaoAleatorioPoke: Button
    private lateinit var botaoResetPoke: Button
    private lateinit var pokemonInput: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this, PokemonViewModelFactory())
            .get(PokemonViewModel::class.java)

        botaoPesquisaPoke = binding.pesquisa
        botaoAleatorioPoke = binding.aleatorio
        botaoResetPoke = binding.reset
        pokemonInput = binding.pokemonInput

        val pokeName = binding.pokeName
        val pokeId = binding.pokeId
        val pokeImage = binding.pokeImage;


        viewModel.pokemonLiveData.observe(this, Observer {

            pokeName.text = it.nome
            pokeId.text = it.nome



            Glide.with(this).load(it.spriteDefault).into(pokeImage);

        })

        getPokemon()
        getPokemonAleatorio()
        resetPokemon()

    }

    private fun getPokemon() {
        botaoPesquisaPoke.setOnClickListener {
            viewModel.getPokemonById((pokemonInput.text.toString()).lowercase())
        }
    }
    private fun getPokemonAleatorio() {
        botaoAleatorioPoke.setOnClickListener {
            viewModel.getPokemonById((Random.nextInt(1, (numberOfPokemon+1))).toString())
        }
    }
    private fun resetPokemon() {
        botaoResetPoke.setOnClickListener {
            viewModel.pokemonLiveData.value = Pokemon("","","",emptyList())
        }
    }
}
