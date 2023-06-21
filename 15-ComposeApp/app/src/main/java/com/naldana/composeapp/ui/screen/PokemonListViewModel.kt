package com.naldana.composeapp.ui.screen

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel
import com.naldana.composeapp.data.Pokemon
import com.naldana.composeapp.data.pokemons

class PokemonListViewModel : ViewModel() {

    val state = mutableStateOf<List<Pokemon>>(getPokemons())

    private fun getPokemons(): List<Pokemon> = pokemons

    fun toggleFavorite(name: String) {
        val pokemonsNew = state.value.toMutableStateList()
        val index = pokemonsNew.indexOfFirst {
            it.name == name
        }
        val item = pokemonsNew[index]
        pokemonsNew[index] = item.copy(favorite = !item.favorite)
        state.value = pokemonsNew
    }
}