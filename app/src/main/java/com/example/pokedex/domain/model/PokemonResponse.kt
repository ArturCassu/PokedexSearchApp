package com.example.pokedex.domain.model

import com.google.gson.annotations.SerializedName

data class PokemonResponse(
    val id: String,
    val name: String,
    val sprites: Sprites,
    val types: List<Type>
)

data class Sprites(
    val other: Other
)

data class Type(
    val type: TypeName
)

data class TypeName(
    val name: String
)
data class Other(
    @SerializedName("official-artwork")
    val officialArtWork: OfficialArtwork
)

data class OfficialArtwork(
    @SerializedName("front_default")
    val frontDefault: String
)