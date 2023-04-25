package com.naldana.booktrackersec02.ui.books

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.naldana.booktrackersec02.R
import com.naldana.booktrackersec02.data.models.Book
import com.naldana.booktrackersec02.databinding.ItemBookBinding

class BooksAdapter(private val onClickBook: (Book) -> Unit) :
    RecyclerView.Adapter<BooksAdapter.ViewHolderBook>() {

    private var books: List<Book>? = null

    class ViewHolderBook(private var binding: ItemBookBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(book: Book, onClickBook: (Book) -> Unit) {
            binding.book = book
            binding.bookName.setOnClickListener {
                onClickBook(book)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderBook {
        val inflater = LayoutInflater.from(parent.context)
        val binding: ItemBookBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.item_book,
            parent,
            false
        )

        return ViewHolderBook(binding)
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