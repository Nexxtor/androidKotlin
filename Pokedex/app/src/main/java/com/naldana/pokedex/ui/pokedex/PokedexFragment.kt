package com.naldana.pokedex.ui.pokedex

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.naldana.pokedex.PokedexApplication
import com.naldana.pokedex.R
import com.naldana.pokedex.databinding.FragmentPokedexBinding

/**
 * Show a list of all pokemons
 * Use the [PokedexFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class PokedexFragment : Fragment() {

    private var _binding: FragmentPokedexBinding? = null
    private val binding get() = _binding!!

    private val application by lazy {
        requireActivity().application as PokedexApplication
    }

    // Va cambiar de lugar
    private val pokemonFactory: PokemonViewModelFactory by lazy {
        val repository = application.pokemonRepository
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
        _binding = FragmentPokedexBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        val adpater = PokemonAdpater()

        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = adpater
        }

        viewModel.pokemons.observe(viewLifecycleOwner) {
            adpater.setData(it)
        }

        viewModel.error.observe(viewLifecycleOwner) { error ->
            val pokemonSearch = binding.pokemonSearch
            if (error == null)
                pokemonSearch.error = null
            else
                pokemonSearch.error = getString(error)
        }

        viewModel.pokemon.observe(viewLifecycleOwner) { pokemon ->
            if (pokemon.id == 0 || pokemon.name.isEmpty())
                binding.displayResult.text = getString(R.string.hint_pokemon_search)
            else
                binding.displayResult.text =
                    getString(R.string.pokemon_data, pokemon.id, pokemon.name)
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