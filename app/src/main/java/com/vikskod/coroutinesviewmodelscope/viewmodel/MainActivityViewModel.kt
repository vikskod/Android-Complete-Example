package com.vikskod.coroutinesviewmodelscope.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vikskod.coroutinesviewmodelscope.model.User
import com.vikskod.coroutinesviewmodelscope.repository.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


/**
 * Created by Vikash Parajuli on 28/01/2021.
 * vparajuli819@gmail.com
 */
class MainActivityViewModel : ViewModel() {

    private var userRepository = UserRepository()

    private var usersData = MutableLiveData<List<User>>()
    val users: LiveData<List<User>> get() = usersData

    fun getUserData() {
        viewModelScope.launch {
            var result: List<User>? = null
            withContext(Dispatchers.IO) {
                result = userRepository.getUsers()
            }
            usersData.value = result
        }
    }
}