package com.vikskod.roomandall.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.vikskod.roomandall.repository.TodoRepository
import java.lang.IllegalArgumentException


/**
 * Created by Vikash Parajuli on 28/01/2021.
 * vparajuli819@gmail.com
 */
class TodoViewModelFactory(private val repository: TodoRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainActivityViewModel::class.java)) {
            return MainActivityViewModel(repository) as T
        }

        throw IllegalArgumentException("Unknown ViewModel Class")
    }
}