package com.naldana.pokedex.ui.pokedex

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.naldana.pokedex.data.Pokemon
import com.naldana.pokedex.repository.PokemonRepository

class PokedexViewModel(private val repository: PokemonRepository) : ViewModel() {


    /**
     * Busca un pokemon
     * @param key [String] Nombre o Numero de Pokemon
     * @return [String] JSON con la información de pokemon
     */
/*    fun search(key: String): Pokemon? {
        var pokemon: Pokemon? = null
        viewModelScope.launch {
            pokemon = repository.search(key)
        }
        return pokemon
    }
*/
    fun search(key: String) = liveData<Pokemon> {
        try {
            emit(repository.search(key))
        } catch (e: Exception) {
            Log.e("PokedexViewModel", "Error al consguier el pokemon", e)
        }
    }


}