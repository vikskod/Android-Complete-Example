package com.vikskod.roomandall.db

import androidx.lifecycle.LiveData
import androidx.room.*


/**
 * Created by Vikash Parajuli on 28/01/2021.
 * vparajuli819@gmail.com
 */

@Dao
interface TodoDao {

    /*
    * Room doesn't support database access on main thread. Use suspend fun for it
    * */

    @Insert
    suspend fun insertTodo(todo: Todo)

    @Update
    suspend fun updateTodo(todo: Todo)

    @Delete
    suspend fun deleteTodo(todo: Todo)

    /*
    * Room checks query error at compile time
    * */
    @Query("DELETE FROM table_todo")
    suspend fun deleteAll()

    /*
    * We don't add suspend modifier because we don't need to execute this function in a
    * background thread using coroutines. Room automatically process this function with LiveData
    * as a return type in a background thread
    * */
    @Query("SELECT * FROM table_todo")
    fun getAllTodo(): LiveData<List<Todo>>
}