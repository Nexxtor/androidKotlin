package com.naldana.pokedex.ui.pokedex

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.naldana.pokedex.R
import com.naldana.pokedex.data.entity.Pokemon
import com.naldana.pokedex.repository.PokemonRepository
import kotlinx.coroutines.launch
import retrofit2.HttpException

class PokedexViewModel(private val repository: PokemonRepository) : ViewModel() {

    var key = MutableLiveData("")
    var pokemon = MutableLiveData<Pokemon>()
    private var _loading = MutableLiveData(View.GONE)
    val loading: LiveData<Int> get() = _loading
    private var _error = MutableLiveData<Int?>(null)
    val error: LiveData<Int?> get() = _error
    val pokemons = repository.findAll()

    /**
     * Busca un pokemon
     */
    fun search() {
        _loading.value = View.VISIBLE
        _error.value = null
        viewModelScope.launch {
            try {
                val key = key.value
                if (key.isNullOrEmpty()) {
                    _error.value = R.string.error_pokemon_empty
                } else {
                    pokemon.value = repository.search(key)
                }

            } catch (e: HttpException) {
                _error.value = R.string.error_not_found
            } finally {
                _loading.value = View.GONE
            }

        }
    }


}