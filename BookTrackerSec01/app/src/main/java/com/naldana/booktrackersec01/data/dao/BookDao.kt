package com.naldana.booktrackersec01.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import com.naldana.booktrackersec01.data.models.Book
import com.naldana.booktrackersec01.data.models.BookAndPublisher

@Dao
interface BookDao {

    @Insert
    suspend fun insertBook(book: Book)

    @Insert
    suspend fun insertAllBook(books: List<Book>)

    @Delete
    suspend fun deleteBook(book: Book)

    @Update
    suspend fun updateBook(book:Book)

    @Query("SELECT * FROM book_table")
    fun getBooks(): LiveData<List<Book>>

    @Query("SELECT * FROM book_table WHERE isbn = :isbn LIMIT 1")
    suspend fun getBookByIsbn(isbn: String): Book

    @Transaction
    @Query("SELECT * FROM publisher_table")
    fun getPublisherWhitBook(): LiveData<List<BookAndPublisher>>
}