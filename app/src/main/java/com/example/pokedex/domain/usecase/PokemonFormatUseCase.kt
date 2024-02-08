package com.example.pokedex.domain.usecase

import android.util.Log
import com.example.pokedex.domain.model.Pokemon

class PokemonFormatUseCase {

    fun pokemonFormat(pokemon:Pokemon): Pokemon{

        //Nome do pokemon
        val returnName = pokemon.nome.replaceFirstChar { it.uppercase() }

        //ID do pokemon
        val returnId: String = when (pokemon.id) {
            "????" -> {
                val id = "N° ${pokemon.id}"
                id
            }

            "" -> {
                ""
            }

            else -> {
                val id = "N° ${String.format("%04d", pokemon.id.toInt())}"
                id
            }
        }

        //Tipo do pokemon
        val returnTypes: MutableList<String> = emptyList<String>().toMutableList()
        try {
            if (pokemon.types.isNotEmpty()){
                for(i in 0..<pokemon.types.size-1){
                    returnTypes.add( pokemon.types[i].replaceFirstChar { it.uppercase() } )
                }
            }
        }catch (e: IndexOutOfBoundsException){
            Log.d("Format List", e.toString() + pokemon.types.toString())
        }

        return Pokemon(
            nome= returnName,
            id= returnId,
            spriteDefault = pokemon.spriteDefault,
            types = returnTypes
        )
    }
}