package com.naldana.pokedex.ui.pokedex

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.naldana.pokedex.R
import com.naldana.pokedex.data.entity.Pokemon

class PokemonsRecyclerViewAdapter :
    RecyclerView.Adapter<PokemonsRecyclerViewAdapter.PokemonViewHolder>() {

    private var data: List<Pokemon>? = null

    fun setData(data: List<Pokemon>) {
        this.data = data
        notifyDataSetChanged()
    }

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
        return PokemonViewHolder(view)
    }

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        val data = data ?: return
        val pokemon = data[position]
        holder.bind(pokemon)

    }

    override fun getItemCount(): Int = data?.size ?: 0
}