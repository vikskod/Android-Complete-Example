package com.vikskod.databinding

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.sampledatabinding.R
import com.example.sampledatabinding.databinding.ActivityDatabindingBinding

class MainDataBindingActivity : AppCompatActivity() {

    //"ActivityDatabinding + Binding => ActivityDatabindingBinding" this class came from activity_databinding.xml
    lateinit var binding: ActivityDatabindingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_databinding)

        // This line will set text in TextView. See XML file for detail
        binding.user = getUserDetail()
    }

    private fun getUserDetail(): User {
        return User("Vikash Parajuli", "Chitwan, Nepal")
    }
}