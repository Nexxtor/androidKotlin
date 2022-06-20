package com.naldana.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    var query = MutableLiveData("")
    var result = Transformations.map(query) { textQuery ->
        if (textQuery.isEmpty())
            "Ingrese una palabra para obtener resultado"
        else
            "El resultado para la query $textQuery es este"
    }


    @Deprecated("Pleas use livedata subscription")
    fun onSearch(){
        val textQuery = query.value
        //result.value = "El resultado para la query $textQuery es este"
    }
}