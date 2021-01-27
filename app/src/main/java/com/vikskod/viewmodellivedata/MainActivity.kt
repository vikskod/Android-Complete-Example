package com.vikskod.viewmodellivedata

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.sampledatabinding.R
import com.example.sampledatabinding.databinding.ActivityViewmodelLivedataBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityViewmodelLivedataBinding
    lateinit var viewModel: MainActivityViewModel
    lateinit var factory: MainActivityViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_viewmodel_livedata)

        // Factory helps to pass value in ViewModel constructor class
        factory = MainActivityViewModelFactory(3)
        viewModel = ViewModelProvider(this, factory).get(MainActivityViewModel::class.java)

        // This will observe the data (Automatically) if the data is changed.
        viewModel.liveData.observe(this, Observer {
            binding.tvResult.text = it.toString()
        })
    }

    fun onAddClicked(view: View) {
        val num = binding.etInput.text.toString()
        if (num.isNotEmpty()) {
            viewModel.add(num.toInt())
        }
    }
}