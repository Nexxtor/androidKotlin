package com.naldana.booktrackersec01.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.naldana.booktrackersec01.data.models.Book

@Dao
interface BookDao {

    @Insert
    fun insertBook(book: Book)

    @Insert
    fun insertAllBook(books: List<Book>)

    @Delete
    fun deleteBook(book: Book)

    @Update
    fun updateBook(book:Book)

    @Query("SELECT * FROM book_table")
    fun getBooks(): LiveData<List<Book>>

    @Query("SELECT * FROM book_table WHERE isbn = :isbn LIMIT 1")
    fun getBookByIsbn(isbn: String): Book
}