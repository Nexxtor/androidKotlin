package com.naldana.booktrackersec01.ui.book.create

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.naldana.booktrackersec01.BookTrackerApplication
import com.naldana.booktrackersec01.repositories.BookRepository

class NewBookViewModel(val bookRepository: BookRepository) : ViewModel() {
    var title = MutableLiveData("")
    var pageCount = MutableLiveData("")
    var subject = MutableLiveData("")
    var summary = MutableLiveData("")
    var isbn = MutableLiveData("")

    // TODO Permitir solo seleccionar un publihser existente
    var publisherId = MutableLiveData("")

    var statusError = MutableLiveData<StatusNewBook>(StatusNewBook.Init)

    fun onSaveClick() {
        statusError.value = StatusNewBook.Init
        if (validateInput()) {
            // Crear un objeto
            // guardarlo
        }

    }

    private fun validateInput(): Boolean {
        val listError = mutableListOf<Pair<FieldBook, List<TypeError>>>()

        val error = mutableListOf<TypeError>()

        if (title.value.isNullOrBlank()) {
            error.add(TypeError.Required)
        }

        title.value?.let {
            if (it.startsWith("-")) {
                error.add(TypeError.BadFormat)
            }
        }

        if (error.size > 0) {
            listError.add(Pair(FieldBook.TITLE, error))
        }

        statusError.value = StatusNewBook.Error(listError)

        return listError.size == 0
    }

    companion object {
        val Factory = viewModelFactory {
            initializer {
                val app = this[APPLICATION_KEY] as BookTrackerApplication
                NewBookViewModel(app.bookRepository)
            }
        }
    }
}

enum class FieldBook {
    TITLE, PAGE_COUNT, SUBJECT, SUMMARY, ISBN
}

enum class TypeError {
    Required, BadFormat
}

sealed class StatusNewBook {
    object Init : StatusNewBook()
    class Error(val errors: List<Pair<FieldBook, List<TypeError>>>) : StatusNewBook()

}