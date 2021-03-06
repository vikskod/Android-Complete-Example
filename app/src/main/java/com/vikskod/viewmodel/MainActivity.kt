package com.vikskod.viewmodel

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.sampledatabinding.R
import com.example.sampledatabinding.databinding.ActivityViewmodelLifecycleBinding
import com.vikskod.viewmodellivedata.MainActivity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityViewmodelLifecycleBinding
    private lateinit var viewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_viewmodel_lifecycle)
        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        binding.tvCount.text = "Count: ${viewModel.getCount()}"
    }

    fun onIncreaseClicked(view: View) {
        binding.tvCount.text = "Count: ${viewModel.increaseCount()}"
    }

    fun onSecondExampleClicked(view: View) {
        startActivity(Intent(this, MainActivity::class.java))
    }
}