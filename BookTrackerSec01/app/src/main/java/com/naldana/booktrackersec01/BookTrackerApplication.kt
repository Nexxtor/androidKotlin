package com.naldana.booktrackersec01

import android.app.Application
import com.naldana.booktrackersec01.data.BookTrackerDatabase
import com.naldana.booktrackersec01.repositories.BookRepository

class BookTrackerApplication : Application() {
    private val db: BookTrackerDatabase by lazy {
        BookTrackerDatabase.getInstance(this)
    }
    val bookRepository: BookRepository by lazy {
        BookRepository(db.bookDao())
    }
}