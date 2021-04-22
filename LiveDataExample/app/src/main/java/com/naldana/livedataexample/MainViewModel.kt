package com.naldana.livedataexample

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import java.util.*

class MainViewModel : ViewModel() {


    private var _message = MutableLiveData<String>()
    val message: LiveData<String>
        get() = _message

    fun setMessage(message: String) {
        // Validaciones
        _message.value = message
    }

    init {
        _message.value = ""
    }

    var messageLowerCase = Transformations.map(message) { message ->
        message.toLowerCase(Locale.ROOT)
    }

}