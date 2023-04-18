package com.naldana.booktrackersec01.repositories

import com.naldana.booktrackersec01.data.Author
import com.naldana.booktrackersec01.data.Book

class BookRepository(private val books: List<Book>) {

    fun getBooks() = books

    fun getBooksByAuthor(author: Author) =
        books.filter { book -> book.authors.contains(author) }
}