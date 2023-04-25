package com.naldana.booktrackersec02

import android.app.Application
import com.naldana.booktrackersec02.data.BookTrackerDatabase
import com.naldana.booktrackersec02.repositories.BooksRepository

class BooksTrackerApplication : Application() {
    private val database: BookTrackerDatabase by lazy {
        BookTrackerDatabase.newInstance(this)
    }
    val booksRepository: BooksRepository by lazy {
        BooksRepository(database.bookDao())
    }
}