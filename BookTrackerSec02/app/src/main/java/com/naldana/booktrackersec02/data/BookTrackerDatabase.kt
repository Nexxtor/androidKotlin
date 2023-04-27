package com.naldana.booktrackersec02.data


import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.naldana.booktrackersec02.data.dao.BookDao
import com.naldana.booktrackersec02.data.models.Book
import com.naldana.booktrackersec02.data.models.Publisher

@Database(entities = [Book::class, Publisher::class], version = 2)
abstract class BookTrackerDatabase : RoomDatabase() {
    abstract fun bookDao(): BookDao

    companion object {
        @Volatile
        private var INSTANCE: BookTrackerDatabase? = null

        fun newInstance(application: Application): BookTrackerDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room
                    .databaseBuilder(
                        application.applicationContext,
                        BookTrackerDatabase::class.java,
                        "booktracker"
                    ).fallbackToDestructiveMigration().build()
                INSTANCE = instance
                instance
            }
        }
    }
}