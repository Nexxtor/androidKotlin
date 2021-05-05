package com.naldana.pokedex.ui.pokedex

import android.util.Log
import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.naldana.pokedex.R
import com.naldana.pokedex.data.Pokemon
import com.naldana.pokedex.repository.PokemonRepository
import kotlinx.coroutines.launch
import retrofit2.HttpException

class PokedexViewModel(private val repository: PokemonRepository) : ViewModel() {

    var searchKey = MutableLiveData<String>("")
    var pokemon = MutableLiveData<Pokemon>()
    var loading = MutableLiveData<Int>(View.GONE)
    var error = MutableLiveData<Int?>(null)

    /**
     * Busca un pokemon con la clave dada
     * @return [String] JSON con la informacion del pokemon o vacio si no se encontro
     */
    fun search() {
        viewModelScope.launch {
            loading.value = View.VISIBLE
            error.value = null
            try {
                pokemon.value = searchKey.value?.let {
                   repository.getPokemon(it)
                }
            } catch (e: HttpException) {
                Log.e("ViewModel", "Error al busacar",e)
                error.value = R.string.pokemon_not_found
            } finally {
                loading.value = View.GONE
            }

        }
    }


}