package com.vikskod.roomandall.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.sampledatabinding.R
import com.example.sampledatabinding.databinding.RvRoomItemBinding
import com.vikskod.roomandall.db.Todo


/**
 * Created by Vikash Parajuli on 28/01/2021.
 * vparajuli819@gmail.com
 */
class TodoAdapter(private var todos: List<Todo>, private val clickListener: (Todo) -> Unit) :
    RecyclerView.Adapter<MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: RvRoomItemBinding =
            DataBindingUtil.inflate(layoutInflater, R.layout.rv_room_item, parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(todos[position], clickListener)
    }

    override fun getItemCount(): Int {
        return todos.size
    }
}

class MyViewHolder(val binding: RvRoomItemBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(todo: Todo, clickListener: (Todo) -> Unit) {
        binding.tvTitle.text = todo.title
        binding.tvDescription.text = todo.description

        binding.cvContainer.setOnClickListener {
            clickListener(todo)
        }
    }
}