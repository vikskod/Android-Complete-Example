package com.vikskod.coroutinesviewmodelscope.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.vikskod.coroutinesviewmodelscope.repository.UserRepository
import kotlinx.coroutines.Dispatchers


/**
 * Created by Vikash Parajuli on 28/01/2021.
 * vparajuli819@gmail.com
 */
class MainActivityViewModel : ViewModel() {

    private var userRepository = UserRepository()

    /*
    * using LiveData to emit the data
    * */
    var users = liveData(Dispatchers.IO) {
        val result = userRepository.getUsers()
        emit(result)
    }

    /*

    These below code is replaced by LiveData Builder

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
    }*/
}