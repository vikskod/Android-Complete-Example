package com.vikskod.coroutinesviewmodelscope.repository

import com.vikskod.coroutinesviewmodelscope.model.User
import kotlinx.coroutines.delay


/**
 * Created by Vikash Parajuli on 28/01/2021.
 * vparajuli819@gmail.com
 */
class UserRepository {
    /*
    * In real app we call here local database / network data
    * */

    suspend fun getUsers(): List<User> {
        delay(5000)
        return listOf(
            User(1, "Vikash", "Chitwan"),
            User(2, "Subheksha", "Butwal"),
            User(3, "Sabin", "Kathmandu"),
            User(4, "Sagar", "Jhapa"),
            User(5, "Bikash", "Chitwan"),
        )
    }
}