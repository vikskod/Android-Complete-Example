package com.vikskod

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.sampledatabinding.R
import com.vikskod.databinding.MainDataBindingActivity
import com.vikskod.viewmodel.MainViewModelLifeCycleActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun onDataBindingClicked(view: View) {
        startActivity(Intent(this, MainDataBindingActivity::class.java))
    }

    fun onViewModelLifeCycleClicked(view: View) {
        startActivity(Intent(this, MainViewModelLifeCycleActivity::class.java))
    }
}