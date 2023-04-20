package com.naldana.booktrackersec01.ui.book

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.naldana.booktrackersec01.R
import com.naldana.booktrackersec01.data.Book

class BookAdapter(private val onClickBook: (Book) -> Unit) : RecyclerView.Adapter<BookAdapter.ViewHolderBook>() {

    private var books: List<Book>? = null

    class ViewHolderBook(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(book: Book, onClickBook: (Book) -> Unit ) {
            val titleTextView: TextView = itemView.findViewById(R.id.book_title)
            titleTextView.text = book.title
            titleTextView.setOnClickListener {
                onClickBook(book)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderBook {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_view, parent, false)
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
    }
}