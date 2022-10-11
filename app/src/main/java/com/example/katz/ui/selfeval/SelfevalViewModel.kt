package com.example.katz.ui.selfeval

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SelfevalViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Autoavaliação emocional Fragment"
    }
    val text: LiveData<String> = _text
}