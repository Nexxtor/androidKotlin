package com.naldana.booktrackersec02.ui.books.create

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.naldana.booktrackersec02.BooksTrackerApplication
import com.naldana.booktrackersec02.R
import com.naldana.booktrackersec02.repositories.BooksRepository

class FormBookViewModel(val booksRepository: BooksRepository) : ViewModel() {

    val title = MutableLiveData("")
    val subject = MutableLiveData("")
    val summary = MutableLiveData("")
    val pageCount = MutableLiveData("")
    val publishYear = MutableLiveData("")
    val isbn = MutableLiveData("")

    val status = MutableLiveData<StatusFromBook>(StatusFromBook.Init)

    fun onSaveBook() {
        status.value = StatusFromBook.Init
        if (validInput()) {
            // Guardar
        }
    }

    private fun validInput(): Boolean {
        val errors = mutableMapOf<FieldBook, List<TypeError>>()

        val errorsTitle = mutableListOf<TypeError>()

        if (title.value.isNullOrBlank()) {
            errorsTitle.add(TypeError.REQUIERED)
        } else {
            errorsTitle.add(TypeError.REQUIERED)
            if (title.value!!.startsWith("-")) {
                errorsTitle.add(TypeError.BADFORMAT)
            }
        }

        if (errorsTitle.size > 0) {
            errors.put(FieldBook.TITLE, errorsTitle)
            errors.put(
                FieldBook.ISBN, listOf(
                    TypeError.REQUIERED
                )
            )
        }

        // Hacer la validadcion de otros campos
        if (errors.size > 0) {
            status.value = StatusFromBook.Error(errors)
            return false
        }
        return true
    }

    companion object {
        val Factory = viewModelFactory {
            initializer {
                val app = this[APPLICATION_KEY] as BooksTrackerApplication
                FormBookViewModel(app.booksRepository)
            }
        }
    }
}

enum class TypeError {
    REQUIERED, BADFORMAT
}

enum class FieldBook {
    TITLE, SUMMARY, ISBN
}

sealed class StatusFromBook {
    object Init : StatusFromBook()
    class Error(val errors: Map<FieldBook, List<TypeError>>) : StatusFromBook()
}