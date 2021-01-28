package com.vikskod.navigationcomponent

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.sampledatabinding.R
import com.example.sampledatabinding.databinding.FragmentPasswordBinding

class PasswordFragment : Fragment() {

    private lateinit var binding: FragmentPasswordBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_password, container, false)
        binding.btnSubmit.setOnClickListener {
            it.findNavController().navigate(R.id.action_passwordFragment_to_termsFragment)
        }
        return binding.root
    }
}