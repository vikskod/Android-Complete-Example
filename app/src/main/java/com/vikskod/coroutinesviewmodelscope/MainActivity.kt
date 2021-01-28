package com.vikskod.coroutinesviewmodelscope

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.sampledatabinding.R
import com.example.sampledatabinding.databinding.ActivityCoroutineViewmodelscopeBinding
import com.vikskod.coroutinesviewmodelscope.viewmodel.MainActivityViewModel


/**
 * Created by Vikash Parajuli on 28/01/2021.
 * vparajuli819@gmail.com
 */
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCoroutineViewmodelscopeBinding
    private lateinit var viewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_coroutine_viewmodelscope)
        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)

        viewModel.getUserData()

        viewModel.users.observe(this, { myUsers ->
            var result = ""
            myUsers.forEach {
                Log.i("User name = ", it.name)
                result += "Name: ${it.name}, Address: ${it.address} \n"
            }
            binding.tv.text = result
        })
    }
}