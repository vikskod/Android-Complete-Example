package com.vikskod.roomandall.viewmodel

import androidx.databinding.Observable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vikskod.roomandall.db.Todo
import com.vikskod.roomandall.repository.TodoRepository
import kotlinx.coroutines.launch


/**
 * Created by Vikash Parajuli on 28/01/2021.
 * vparajuli819@gmail.com
 */

/*
* To use the bindable text in ViewModel it should be implemented Observable(androidx.databinding) interface
* */
class MainActivityViewModel(private val repository: TodoRepository) : ViewModel(), Observable {

    val todos = repository.todos

    val inputTitle = MutableLiveData<String>()
    val inputDescription = MutableLiveData<String>()
    val saveOrUpdateBtnText = MutableLiveData<String>()
    val deleteOrDeleteAllBtnText = MutableLiveData<String>()

    private var isUpdateOrDelete = false
    private lateinit var todoToUpdateOrDelete: Todo

    init {
        saveOrUpdateBtnText.value = "Save"
        deleteOrDeleteAllBtnText.value = "Delete All"
    }

    fun saveOrUpdate() {
        if (isUpdateOrDelete) {
            todoToUpdateOrDelete.title = inputTitle.value!!
            todoToUpdateOrDelete.description = inputDescription.value!!
            updateTodo(todoToUpdateOrDelete)
        } else {
            val title = inputTitle.value!!
            val description = inputDescription.value!!

            insertTodo(Todo(0, title, description))
            inputTitle.value = null
            inputDescription.value = null
        }
    }

    fun deleteOrDeleteAll() {
        if (isUpdateOrDelete)
            deleteTodo(todoToUpdateOrDelete)
        else
            deleteAll()
    }

    private fun insertTodo(todo: Todo) {
        viewModelScope.launch {
            repository.insert(todo)
        }
    }

    private fun updateTodo(todo: Todo) {
        viewModelScope.launch {
            repository.update(todo)
        }

        inputTitle.value = null
        inputDescription.value = null
        isUpdateOrDelete = false

        saveOrUpdateBtnText.value = "Save"
        deleteOrDeleteAllBtnText.value = "Delete All"
    }

    private fun deleteTodo(todo: Todo) {
        viewModelScope.launch {
            repository.delete(todo)
        }

        inputTitle.value = null
        inputDescription.value = null
        isUpdateOrDelete = false

        saveOrUpdateBtnText.value = "Save"
        deleteOrDeleteAllBtnText.value = "Delete All"
    }

    private fun deleteAll() {
        viewModelScope.launch {
            repository.deleteAll()
        }
    }

    fun initUpdateAndDelete(todo: Todo) {
        inputTitle.value = todo.title
        inputDescription.value = todo.description

        isUpdateOrDelete = true
        todoToUpdateOrDelete = todo

        saveOrUpdateBtnText.value = "Update"
        deleteOrDeleteAllBtnText.value = "Delete"
    }

    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {

    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {

    }

}