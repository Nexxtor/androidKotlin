package com.naldana.booktrackersec02.ui.books

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.naldana.booktrackersec02.R
import com.naldana.booktrackersec02.data.Book

class BooksAdapter(private val onClickBook: (Book) -> Unit) : RecyclerView.Adapter<BooksAdapter.ViewHolderBook>() {

    private var books: List<Book>? = null

    class ViewHolderBook(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(book: Book, onClickBook: (Book) -> Unit ) {
            val titleTextView = itemView.findViewById<TextView>(R.id.book_name)
            titleTextView.text = book.title
            titleTextView.setOnClickListener {
                onClickBook(book)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderBook {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater
            .inflate(
                R.layout.item_book, parent,
                false
            )
        return ViewHolderBook(view)
    }

    override fun getItemCount(): Int = books?.size ?: 0

    override fun onBindViewHolder(holder: ViewHolderBook, position: Int) {
        books?.let {
            holder.bind(it[position], onClickBook)
        }
    }

    fun submitData(books: List<Book>) {
        this.books = books
        notifyDataSetChanged()
    }
}