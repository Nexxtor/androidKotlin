package com.naldana.conversor

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private var _dolares = MutableLiveData(0.0)
    val dolares: LiveData<Double>
        get() = _dolares

    private var _yuanes = MutableLiveData(0.0)
    val yuanes: LiveData<Double>
        get() = _yuanes

    private val tazaConversion = 0.15


    fun setDolares(cantidad: Double) {
        _dolares.value = cantidad
        dolaresToYuanes()
    }

    private fun dolaresToYuanes() {
        _yuanes.value = _dolares.value?.times(tazaConversion)
    }

}