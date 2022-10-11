package com.example.katz.ui.avaliacoes

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AvaliacoesViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is avaliacoes Fragment"
    }
    val text: LiveData<String> = _text
}