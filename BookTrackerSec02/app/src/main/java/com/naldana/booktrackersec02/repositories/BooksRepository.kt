package com.naldana.booktrackersec02.repositories

import com.naldana.booktrackersec02.data.dao.BookDao
import com.naldana.booktrackersec02.data.models.Author
import com.naldana.booktrackersec02.data.models.Book

class BooksRepository(private val booksDao: BookDao) {

    fun getBooks() = booksDao.getBooks()

    suspend fun getBooksByIsbn(isbn: String) = booksDao.getBook(isbn)
    suspend fun insertBook(book: Book) {
        booksDao.insertBook(book)
    }
}