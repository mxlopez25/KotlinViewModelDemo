package dev.codedark.kotlinviewmodeldemo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SecondActivityViewModel: ViewModel() {
    private var _number3 = MutableLiveData<Int>(0)
    private var _number4 = MutableLiveData<Int>(0)

    val number3: LiveData<Int> = _number3
    var number4: LiveData<Int> = _number4

    fun addNumber3() {
        _number3.value = _number3.value?.plus(1)
    }

    fun addNumber4() {
        _number4.value = _number4.value?.plus(1)
    }
}