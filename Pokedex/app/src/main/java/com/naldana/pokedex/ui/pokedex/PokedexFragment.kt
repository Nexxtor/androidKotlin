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
 * Pantalla de busqueda de pokemons
 * Use the [PokedexFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class PokedexFragment : Fragment() {

    private val pokedexFactory by lazy {
        val repository = PokemonRepository()
        PokedexViewModelFactory(repository)
    }

    private val pokedexViewModel: PokedexViewModel by viewModels {
        pokedexFactory
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
        val keyEditText = view.findViewById<EditText>(R.id.search_text)
        val searchButton = view.findViewById<Button>(R.id.action_search)
        val displayPokemon = view.findViewById<TextView>(R.id.display_pokemon)

        searchButton.setOnClickListener {
            val key = keyEditText.text.toString()
            val result = pokedexViewModel.search(key)
            result.observe(viewLifecycleOwner) { pokemon ->
                displayPokemon.text = "${pokemon.id} - ${pokemon.name}  "
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
        fun newInstance(param1: String, param2: String) =
            PokedexFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
}