package dev.codedark.kotlinviewmodeldemo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel: ViewModel() {
    private var _total = MutableLiveData(0)
    val total: LiveData<Int> = _total
    var number1 = 0
    var number2 = 0

    fun addFirstNumber() {
        number1++
        saveTotal()
    }

    fun addSecondNumber() {
        number2++
        saveTotal()
    }

    fun saveTotal() {
        _total.value = number1 + number2
    }
}