package com.vikskod.navigationcomponent

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.sampledatabinding.R
import com.example.sampledatabinding.databinding.FragmentEmailBinding

class EmailFragment : Fragment() {

    private lateinit var binding: FragmentEmailBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_email, container, false)

        binding.btnSubmit.setOnClickListener {
            /*val bundle = bundleOf("user_input" to binding.etName.text.toString())
            it.findNavController().navigate(R.id.action_homeFragment_to_secondFragment, bundle)*/
            it.findNavController().navigate(R.id.action_emailFragment_to_passwordFragment)
        }


        return binding.root
    }

}