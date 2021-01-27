package com.vikskod.viewmodel.secondexample

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.sampledatabinding.R
import com.example.sampledatabinding.databinding.ActivityViewmodelLifecycleSecondBinding

class MainSecondActivity : AppCompatActivity() {

    lateinit var binding: ActivityViewmodelLifecycleSecondBinding
    lateinit var viewModel: MainSecondActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_viewmodel_lifecycle_second)
        viewModel = ViewModelProvider(this).get(MainSecondActivityViewModel::class.java)
        binding.tvResult.text = viewModel.getResult().toString()
    }

    fun onAddClicked(view: View) {
        val num = binding.etInput.text.toString()
        Log.i("Num ===", num)
        if (num.isNotEmpty()) {
            viewModel.add(num.toInt())
            binding.tvResult.text = viewModel.getResult().toString()
        }
    }
}