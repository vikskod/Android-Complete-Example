package com.vikskod.roomandall.repository

import com.vikskod.roomandall.db.Todo
import com.vikskod.roomandall.db.TodoDao


/**
 * Created by Vikash Parajuli on 28/01/2021.
 * vparajuli819@gmail.com
 */
class TodoRepository(private val dao: TodoDao) {

    val todos = dao.getAllTodo()

    suspend fun insert(todo: Todo) {
        dao.insertTodo(todo)
    }

    suspend fun update(todo: Todo) {
        dao.updateTodo(todo)
    }

    suspend fun delete(todo: Todo) {
        dao.deleteTodo(todo)
    }

    suspend fun deleteAll() {
        dao.deleteAll()
    }
}