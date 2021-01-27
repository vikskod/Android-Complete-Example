package com.vikskod.viewmodel

import androidx.lifecycle.ViewModel

class MainActivityViewModel : ViewModel() {
    private var count = 0

    fun getCount(): Int {
        return count
    }

    fun getIncreaseCount(): Int {
        return ++count
    }
}