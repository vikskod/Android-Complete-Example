package com.vikskod.twowaydatabinding

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


/**
 * Created by Vikash Parajuli on 27/01/2021.
 * vparajuli819@gmail.com
 */
class MainActivityViewModel : ViewModel() {
    private var total = MutableLiveData<Int>()
    val totalData: LiveData<Int>get() = total

    val inputText = MutableLiveData<String>()

    init {
        total.value = 0
        inputText.value = "0"
    }

    fun setTotal() {
        val intInput: Int = inputText.value!!.toInt()
        total.value = (total.value)?.plus(intInput)
    }
}