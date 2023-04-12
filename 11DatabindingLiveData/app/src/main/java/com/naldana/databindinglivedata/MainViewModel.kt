package com.naldana.databindinglivedata

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.map

class MainViewModel : ViewModel() {
    var name = MutableLiveData("")

    var greeting = name.map { _name ->
        "Map $_name"
    }
    var iva = name.map {
        2
    }


}