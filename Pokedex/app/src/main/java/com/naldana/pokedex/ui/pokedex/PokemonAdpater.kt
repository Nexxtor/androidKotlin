package com.naldana.pokedex.ui.pokedex

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.naldana.pokedex.R
import com.naldana.pokedex.data.entity.Pokemon

class PokemonAdpater : RecyclerView.Adapter<PokemonAdpater.PokemonViewHolder>() {

    private var pokemons: List<Pokemon>? = null
    private var count: Int = 1;

    class PokemonViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(pokemon: Pokemon) {
            val idTextView = itemView.findViewById<TextView>(R.id.idPokemon)
            val nameTextView = itemView.findViewById<TextView>(R.id.namePokemon)
            idTextView.text = pokemon.id.toString()
            nameTextView.text = pokemon.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_pokemon, parent, false)
        view.findViewById<TextView>(R.id.idViewHolde).text = count.toString()
        count++;
        return PokemonViewHolder(view)
    }

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        pokemons?.let {
            val pokemon = it[position]
            holder.bind(pokemon);
        }
    }

    override fun getItemCount(): Int = pokemons?.size ?: 0


    fun setData(pokemons: List<Pokemon>?) {
        this.pokemons = pokemons
        notifyDataSetChanged()
    }

}