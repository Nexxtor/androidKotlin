package com.naldana.booktrackersec02.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import com.naldana.booktrackersec02.data.models.Book
import com.naldana.booktrackersec02.data.models.BookAndPublisher

@Dao
interface BookDao {

    @Insert
    suspend fun insertBook(book: Book)

    @Insert
    suspend fun insertAllBook(book: List<Book>)

    @Update
    suspend fun updateBook(book: Book)

    @Delete
    suspend fun deleteBook(book: Book)

    @Query("SELECT * FROM book_table")
    fun getBooks(): LiveData<List<Book>>

    @Query("SELECT * FROM book_table WHERE isbn = :isbn")
    suspend fun getBook(isbn: String): Book
    @Transaction
    @Query("SELECT * FROM publisher_table")
    fun getBookAndPublisher(): LiveData<List<BookAndPublisher>>
}