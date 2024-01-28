package com.example.pokedex.model

data class Pokemon(
    val id: String,
    val nome: String,
    val spriteDefault: String,
    val types: List<String>
)
