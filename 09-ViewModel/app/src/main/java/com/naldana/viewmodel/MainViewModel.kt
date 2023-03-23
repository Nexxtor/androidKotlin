package com.naldana.viewmodel

import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    var name = ""

    /**
     * Create a greeting for given name
     *
     * @return Greeting or Hint String <String>
     */
    fun getGreeting() =
        if (name.isEmpty()) {
            "Ingrese un nombre para ser saludado"
        } else {
            "Hola $name"
        }

}