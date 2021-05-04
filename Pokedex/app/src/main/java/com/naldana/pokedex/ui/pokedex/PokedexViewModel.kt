package com.naldana.pokedex.ui.pokedex

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.naldana.pokedex.repository.PokemonRepository

class PokedexViewModel(private val repository: PokemonRepository) : ViewModel() {

    /**
     * Busca un pokemon con la clave dada
     * @param key Nombre o número de pokemon
     * @return [String] JSON con la informacion del pokemon o vacio si no se encontro
     */
    fun search(key: String) = liveData {
        emit(repository.getPokemon(key))
    }


}