package com.example.vmodelkotlin

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    var mainCounter = MutableLiveData<String>.apply { value = "0" }
}