package com.naldana.booktrackersec01.ui.book.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.naldana.booktrackersec01.BookTrackerApplication
import com.naldana.booktrackersec01.data.models.Book
import com.naldana.booktrackersec01.repositories.BookRepository
import kotlinx.coroutines.launch

class BooksViewModel(private val repository: BookRepository) : ViewModel() {

    fun getBooks() = repository.getBooks()
    fun insertBook(book: Book) {
        viewModelScope.launch {
            repository.insertBook(book)
        }
    }

    companion object {
        val Factory = viewModelFactory {
            initializer {
                val app = this[APPLICATION_KEY] as BookTrackerApplication
                BooksViewModel(app.bookRepository)
            }
        }
    }

}