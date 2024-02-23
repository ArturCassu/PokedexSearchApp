package com.example.pokedex

import com.example.pokedex.data.api.PokeApi
import com.example.pokedex.data.repository.PokeRepositoryImpl
import com.example.pokedex.domain.model.OfficialArtwork
import com.example.pokedex.domain.model.Other
import com.example.pokedex.domain.model.Pokemon
import com.example.pokedex.domain.model.PokemonResponse
import com.example.pokedex.domain.model.Sprites
import com.example.pokedex.domain.model.Type
import com.example.pokedex.domain.model.TypeName
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class RequestsUnitTests {
    @Test
    fun `PokeRepositoryImpl getPokemon retorna um objeto do tipo pokemon`() = runBlocking {
        val pokemon = Pokemon(
            id = "1",
            nome = "bulbasaur",
            spriteDefault = "",
            types = (listOf("grass","poison"))
        )
        val api: PokeApi = mockk()
        coEvery { api.getPokemon("1") } coAnswers { PokemonResponse(
            id="1",
            name="bulbasaur",
            sprites = Sprites(Other(OfficialArtwork(""))),
            types = listOf(Type(TypeName("grass")),Type(TypeName("poison")))
        ) }

        assertEquals(PokeRepositoryImpl(api).getPokemonById("1").first(), pokemon)
    }
}