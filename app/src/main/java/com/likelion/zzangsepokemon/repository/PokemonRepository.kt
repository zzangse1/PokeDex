package com.likelion.zzangsepokemon.repository

import com.likelion.zzangsepokemon.data.remote.PokeApi
import com.likelion.zzangsepokemon.data.remote.responses.Pokemon
import com.likelion.zzangsepokemon.data.remote.responses.PokemonList
import com.likelion.zzangsepokemon.util.Resource
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class PokemonRepository @Inject constructor(
    private val api: PokeApi
) {
    suspend fun getPokemonList(limit: Int, offset: Int): Resource<PokemonList> {
        val response = try {
            api.getPokemonList(limit, offset)
        } catch (e: Exception) {
            return Resource.Error(message = "An unknown error occured.")
        }
        return Resource.Success(data = response)
    }

    suspend fun getPokemonInfo(pokemonName: String): Resource<Pokemon> {
        val response = try {
            api.getPokemonInfo(pokemonName)
        } catch (e: Exception) {
            return Resource.Error(message = "An unknown error occured.")
        }
        return Resource.Success(data = response)
    }
}