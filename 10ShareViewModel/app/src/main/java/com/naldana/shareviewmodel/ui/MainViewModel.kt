package com.naldana.shareviewmodel.ui

import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    var name = ""
    var lastname = ""
    var money = ""
    private var phase = 1

    fun getResume() = "Name: $name\n Lastname: $lastname\n Money: $money"

    fun nextPhase() {
        phase++
    }

    fun previousPhase() {
        phase--
    }

    fun currentPhase() = phase
}