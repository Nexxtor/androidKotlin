package com.naldana.booktrackersec02

import android.app.Application
import com.naldana.booktrackersec02.data.books
import com.naldana.booktrackersec02.repositories.BooksRepository

class BooksTrackerApplication : Application() {
    val booksRepository: BooksRepository by lazy {
        BooksRepository(books)
    }
}