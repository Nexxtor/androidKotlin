package com.naldana.pokedex.ui.pokedex

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.naldana.pokedex.repository.PokemonRepository
import java.lang.Exception

class PokedexViewModelFactory(private val repository: PokemonRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(PokedexViewModel::class.java)) {
            return PokedexViewModel(repository) as T
        }
        throw Exception("Unknown ViewModel Class")
    }
}