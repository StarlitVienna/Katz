package com.example.katz.ui.calendario

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CalendarioViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is calendário Fragment"
    }
    val text: LiveData<String> = _text
}