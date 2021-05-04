package com.naldana.pokedex.ui.pokedex

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.naldana.pokedex.R
import com.naldana.pokedex.repository.PokemonRepository

/**
 * Show a list of all pokemons
 * Use the [PokedexFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class PokedexFragment : Fragment() {

    // Va cambiar de lugar
    private val pokemonFactory: PokemonViewModelFactory by lazy {
        val repository = PokemonRepository()
        PokemonViewModelFactory(repository)
    }

    private val viewModel: PokedexViewModel by viewModels {
        pokemonFactory
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pokedex, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val searchEditText = view.findViewById<EditText>(R.id.pokemon_search)
        val actionSearch = view.findViewById<Button>(R.id.action_find)
        val displayPokemon = view.findViewById<TextView>(R.id.display_result)

        actionSearch.setOnClickListener {
            val key = searchEditText.text.toString()
            viewModel.search(key).observe(viewLifecycleOwner) {
                displayPokemon.text = "${it.name} , ${it.id}"
            }
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @return A new instance of fragment PokedexFragment.
         */
        @JvmStatic
        fun newInstance() =
            PokedexFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
}