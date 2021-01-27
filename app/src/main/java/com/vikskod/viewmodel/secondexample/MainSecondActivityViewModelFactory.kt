package com.vikskod.viewmodel.secondexample

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider


/**
 * Created by Vikash Parajuli on 27/01/2021.
 * vparajuli819@gmail.com
 */
class MainSecondActivityViewModelFactory(private val startingTotal: Int) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainSecondActivityViewModel::class.java)) {
            return MainSecondActivityViewModel(startingTotal) as T
        }

        throw IllegalAccessException("Unknown ViewModel Class")
    }
}