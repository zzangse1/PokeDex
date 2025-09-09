package com.likelion.zzangsepokemon.pokemondetail

import androidx.lifecycle.ViewModel
import com.likelion.zzangsepokemon.data.remote.responses.Pokemon
import com.likelion.zzangsepokemon.repository.PokemonRepository
import com.likelion.zzangsepokemon.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PokemonDetailViewModel @Inject constructor(
    private val repository: PokemonRepository
) : ViewModel() {
    suspend fun getPokemonInfo(pokemonName: String): Resource<Pokemon> {
        return repository.getPokemonInfo(pokemonName )
    }
}