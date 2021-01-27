package com.vikskod.twowaydatabinding

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.sampledatabinding.R
import com.example.sampledatabinding.databinding.ActivityTwowayDatabindingBinding


/**
 * Created by Vikash Parajuli on 27/01/2021.
 * vparajuli819@gmail.com
 */
class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityTwowayDatabindingBinding
    lateinit var viewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_twoway_databinding)
        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)

        binding.myViewModel = viewModel
        // We are using live data, we need to save this activity as the lifecycle owner
        binding.lifecycleOwner = this
    }
}