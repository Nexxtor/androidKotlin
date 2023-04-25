package com.naldana.booktrackersec02.repositories

import com.naldana.booktrackersec02.data.dao.BookDao
import com.naldana.booktrackersec02.data.models.Author
import com.naldana.booktrackersec02.data.models.Book

class BooksRepository(private val booksDao: BookDao) {

    fun getBooks() = booksDao.getBooks()

    fun getBooksByIsbn(isbn: String) = booksDao.getBook(isbn)
}