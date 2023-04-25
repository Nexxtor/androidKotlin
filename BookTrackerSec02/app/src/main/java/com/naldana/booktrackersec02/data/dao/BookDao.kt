package com.naldana.booktrackersec02.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.naldana.booktrackersec02.data.models.Book

@Dao
interface BookDao {

    @Insert
    fun insertBook(book: Book)

    @Insert
    fun insertAllBook(book: List<Book>)

    @Update
    fun updateBook(book: Book)

    @Delete
    fun deleteBook(book: Book)

    @Query("SELECT * FROM book_table")
    fun getBooks(): LiveData<List<Book>>

    @Query("SELECT * FROM book_table WHERE isbn = :isbn")
    fun getBook(isbn: String): Book
}