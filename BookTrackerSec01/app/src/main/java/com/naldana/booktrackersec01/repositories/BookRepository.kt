package com.naldana.booktrackersec01.repositories

import com.naldana.booktrackersec01.data.dao.BookDao
import com.naldana.booktrackersec01.data.models.Book

class BookRepository(private val bookDao: BookDao) {

    fun getBooks() = bookDao.getBooks()

    suspend fun getBooksByIsbn(isbn: String) = bookDao.getBookByIsbn(isbn)
    suspend fun insertBook(book: Book) {
        bookDao.insertBook(book)
    }
}