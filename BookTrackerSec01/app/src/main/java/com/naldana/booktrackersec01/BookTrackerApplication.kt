package com.naldana.booktrackersec01

import android.app.Application
import com.naldana.booktrackersec01.data.books
import com.naldana.booktrackersec01.repositories.BookRepository

class BookTrackerApplication: Application() {
    val bookRepository: BookRepository by lazy {
        BookRepository(books)
    }
}