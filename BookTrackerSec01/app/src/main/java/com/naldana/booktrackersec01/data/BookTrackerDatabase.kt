package com.naldana.booktrackersec01.data

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.naldana.booktrackersec01.data.dao.BookDao
import com.naldana.booktrackersec01.data.models.Book

@Database(entities = [Book::class], version = 1)
abstract class BookTrackerDatabase : RoomDatabase() {
    abstract fun bookDao(): BookDao

    companion object {
        private var INSTANCE: BookTrackerDatabase? = null

        fun getInstance(application: Application): BookTrackerDatabase =
            INSTANCE ?: synchronized(this) {
                val instance = Room
                    .databaseBuilder(
                        application.applicationContext,
                        BookTrackerDatabase::class.java,
                        "book_database"
                    )
                    .build()
                INSTANCE = instance
                instance
            }
    }
}