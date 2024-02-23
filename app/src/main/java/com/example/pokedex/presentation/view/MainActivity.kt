package com.example.pokedex.presentation.view

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.pokedex.databinding.ActivityMainBinding
import com.example.pokedex.domain.model.Pokemon
import com.example.pokedex.presentation.adapter.PokeTypeAdapter
import com.example.pokedex.viewmodel.PokemonViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val numberOfPokemon = 1025

    private val viewModel: PokemonViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        viewModel.pokemonLiveData.observe(this) {

            binding.pokeName.text = it.nome
            binding.pokeId.text = it.id

            binding.pokeTypes.layoutManager =
                LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
            binding.pokeTypes.adapter = PokeTypeAdapter(it.types)
            Log.d("RecyclerView Adapter", "onCreate: " + it.types.toString())

            Glide.with(this).load(it.spriteDefault).into(binding.pokeImage);

        }

        getPokemon()
        getPokemonAleatorio()
        resetPokemon()

    }

    private fun getPokemon() {
        binding.pesquisa.setOnClickListener {
            viewModel.getPokemonById((binding.pokemonInput.text.toString()).lowercase())
        }
    }
    private fun getPokemonAleatorio() {
        binding.aleatorio.setOnClickListener {
            viewModel.getPokemonById((Random.nextInt(1, (numberOfPokemon+1))).toString())
        }
    }
    private fun resetPokemon() {
        binding.reset.setOnClickListener {
            viewModel.pokemonLiveData.value = Pokemon("","","",emptyList())
        }
    }
}
