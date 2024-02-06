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
import com.example.pokedex.domain.model.Pokemon
import com.example.pokedex.viewmodel.PokemonViewModel
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private val numberOfPokemon = 1025

    private lateinit var viewModel: PokemonViewModel

    private lateinit var botaoPesquisaPoke: Button
    private lateinit var botaoAleatorioPoke: Button
    private lateinit var botaoResetPoke: Button
    private lateinit var pokemonInput: EditText

    private lateinit var pokeName: TextView
    private lateinit var pokeId: TextView
    private lateinit var pokeType1: TextView
    private lateinit var pokeType2: TextView
    private lateinit var pokeImage: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this, PokemonViewModelFactory())
            .get(PokemonViewModel::class.java)

        botaoPesquisaPoke = findViewById<Button>(R.id.pesquisa)
        botaoAleatorioPoke = findViewById<Button>(R.id.aleatorio)
        botaoResetPoke = findViewById<Button>(R.id.reset)
        pokemonInput = findViewById<EditText>(R.id.pokemonInput)


        pokeName = findViewById<TextView>(R.id.pokeName)
        pokeId = findViewById<TextView>(R.id.pokeId)
        pokeType1 = findViewById<TextView>(R.id.pokeType1)
        pokeType2 = findViewById<TextView>(R.id.pokeType2)
        pokeImage = findViewById(R.id.pokeImage);


        viewModel.pokemonLiveData.observe(this, Observer {
            dataChange(it)
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

    private fun dataChange(pokemon: Pokemon){
        pokeName.text = pokemon.nome.replaceFirstChar { it.uppercase() }

        when (pokemon.id) {
            "????" -> {
                val id = "N° ${pokemon.id}"
                pokeId.text = id
            }
            "" -> {
                pokeId.text = ""
            }
            else -> {
                val id = "N° ${String.format("%04d", pokemon.id.toInt())}"
                pokeId.text = id
            }
        }



        pokeType1.text = ""
        pokeType2.text = ""
        if (pokemon.types.isNotEmpty()){
            for(i in 0..<pokemon.types.size){
                when(i){
                    0 -> {pokeType1.text = pokemon.types[i].replaceFirstChar { it.uppercase() } }
                    1 -> {pokeType2.text = pokemon.types[i].replaceFirstChar { it.uppercase() }}
                }
            }
        }
        Glide.with(this).load(pokemon.spriteDefault).into(pokeImage);
    }
}