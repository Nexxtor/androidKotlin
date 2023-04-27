package com.naldana.booktrackersec02.ui.books

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.naldana.booktrackersec02.BooksTrackerApplication
import com.naldana.booktrackersec02.data.models.Book
import com.naldana.booktrackersec02.repositories.BooksRepository
import kotlinx.coroutines.launch


class BooksViewModel(val booksRepository: BooksRepository) : ViewModel() {
    fun getBooks() = booksRepository.getBooks()
    fun insertBook(book: Book) {
        viewModelScope.launch {
            booksRepository.insertBook(book)
        }
    }

    companion object {
        val Factory = viewModelFactory {
            initializer {
                val booksRepository =
                    (this[APPLICATION_KEY] as BooksTrackerApplication).booksRepository
                BooksViewModel(booksRepository)
            }
        }
    }

}