package com.vikskod.roomandall

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sampledatabinding.R
import com.example.sampledatabinding.databinding.ActivityRoomBinding
import com.vikskod.roomandall.db.Todo
import com.vikskod.roomandall.db.TodoDao
import com.vikskod.roomandall.db.TodoDatabase
import com.vikskod.roomandall.repository.TodoRepository
import com.vikskod.roomandall.view.adapter.TodoAdapter
import com.vikskod.roomandall.viewmodel.MainActivityViewModel
import com.vikskod.roomandall.viewmodel.TodoViewModelFactory

/**
 * Created by Vikash Parajuli on 28/01/2021.
 * vparajuli819@gmail.com
 */
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRoomBinding
    private lateinit var viewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_room)

        val dao: TodoDao = TodoDatabase.getInstance(applicationContext).todoDao
        val repository = TodoRepository(dao)

        val factory = TodoViewModelFactory(repository)
        viewModel = ViewModelProvider(this, factory).get(MainActivityViewModel::class.java)

        binding.myViewModel = viewModel
        binding.lifecycleOwner = this

        initRecyclerView()
    }

    private fun initRecyclerView() {
        binding.rvTodo.layoutManager = LinearLayoutManager(this)
        showTodoList()
    }

    private fun showTodoList() {
        viewModel.todos.observe(this, {
            Log.i("MyTag =", it.toString())
            binding.rvTodo.adapter = TodoAdapter(it) { item: Todo -> listItemClicked(item) }
        })
    }

    private fun listItemClicked(todo: Todo) {
        viewModel.initUpdateAndDelete(todo)
    }
}