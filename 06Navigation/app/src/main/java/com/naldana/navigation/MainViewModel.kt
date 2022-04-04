package com.naldana.navigation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {
    var name = MutableLiveData("")
    var lastName = MutableLiveData("")
}