package com.naldana.pokemonApp.ui.list

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import androidx.paging.cachedIn
import com.naldana.pokemonApp.PokemonApplication
import com.naldana.pokemonApp.models.Pokemon
import com.naldana.pokemonApp.repositories.PokemonRepository
import kotlinx.coroutines.launch

class PokemonListViewModel(private val pokemonRepository: PokemonRepository) : ViewModel() {

    val pokemons = pokemonRepository
        .getPokemonPage(10)


    companion object {
        val Factory = viewModelFactory {
            initializer {
                val app = this[APPLICATION_KEY] as PokemonApplication
                PokemonListViewModel(app.pokemonRepository)
            }
        }
    }
}