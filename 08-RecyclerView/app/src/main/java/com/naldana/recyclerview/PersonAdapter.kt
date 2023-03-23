package com.naldana.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PersonAdapter : RecyclerView.Adapter<PersonAdapter.ViewHolder>() {

    private var persons: List<Person>? = null

    inner class ViewHolder(var itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(person: Person) {
            val nameTextView: TextView = itemView.findViewById(R.id.name_text_view)
            nameTextView.text = person.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_person, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = persons?.size ?: 0


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        persons?.let {
            holder.bind(it[position])
        }
    }

    fun setData(persons: List<Person>) {
        this.persons = persons
        notifyDataSetChanged()
    }
}