package com.example.vmodelkotlin

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    var mainCounter = MutableLiveData<String>().apply { value = counter.toString() }
    private var counter:Int = 0

    private fun setMainCounter() {
        mainCounter.value = counter.toString()
    }

    private fun validateCounter() {
        counter++

        if(counter > 7) {
            counter = 0
        }

        setMainCounter()
    }

    fun counter() {
        validateCounter()
    }
}