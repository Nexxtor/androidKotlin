package com.naldana.booktrackersec02.repositories

import com.naldana.booktrackersec02.data.Author
import com.naldana.booktrackersec02.data.Book

class BooksRepository(private val books: List<Book>) {

    fun getBooks() = books

    fun getBooksByAuthor(author: Author) =
        books.filter { book -> book.authors.contains(author) }
}