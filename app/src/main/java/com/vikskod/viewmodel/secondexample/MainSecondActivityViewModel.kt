package com.vikskod.viewmodel.secondexample

import androidx.lifecycle.ViewModel


/**
 * Created by Vikash Parajuli on 27/01/2021.
 * vparajuli819@gmail.com
 */
class MainSecondActivityViewModel : ViewModel() {
    private var total: Int = 0

    fun add(number: Int) {
        total += number
    }

    fun getResult(): Int {
        return total
    }
}