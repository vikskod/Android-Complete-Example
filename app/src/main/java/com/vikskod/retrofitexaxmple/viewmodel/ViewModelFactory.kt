package com.vikskod.retrofitexaxmple.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.vikskod.retrofitexaxmple.repository.NewsRepository
import java.lang.IllegalArgumentException


/**
 * Created by Vikash Parajuli on 29/01/2021.
 * vparajuli819@gmail.com
 */
class ViewModelFactory(private val app: Application, private val repository: NewsRepository) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainActivityViewModel::class.java)) {
            return MainActivityViewModel(app, repository) as T
        }

        throw IllegalArgumentException("Unknown ViewModel Class")
    }
}