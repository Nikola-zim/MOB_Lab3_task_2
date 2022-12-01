package com.example.task_2.ui.home


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class HomeViewModel : ViewModel() {


    private val _text = MutableLiveData<String>().apply {
        value = "Кол-во в литрах"
    }
    val text: LiveData<String> = _text

    private val _text2 = MutableLiveData<String>().apply {
        value = "qwerty"
    }


    val text2: LiveData<String> = _text2
}