package com.vikskod.viewmodellivedata

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


/**
 * Created by Vikash Parajuli on 27/01/2021.
 * vparajuli819@gmail.com
 */
class MainActivityViewModel(startTotal: Int) : ViewModel() {
    private var mutableLd = MutableLiveData<Int>()
    val liveData: LiveData<Int> get() = mutableLd

    // Setting initial value from the constructor for this I'm using ViewModel Factory
    init {
        mutableLd.value = startTotal
    }

    fun add(input: Int) {
        mutableLd.value = (mutableLd.value)?.plus(input)
    }
}