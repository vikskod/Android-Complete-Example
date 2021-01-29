package com.vikskod.retrofitexaxmple

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sampledatabinding.R
import com.example.sampledatabinding.databinding.ActivityRetrofitBinding
import com.vikskod.retrofitexaxmple.repository.NewsRepository
import com.vikskod.retrofitexaxmple.ui.adapter.MyAdapter
import com.vikskod.retrofitexaxmple.utils.Resource
import com.vikskod.retrofitexaxmple.viewmodel.MainActivityViewModel
import com.vikskod.retrofitexaxmple.viewmodel.ViewModelFactory


/**
 * Created by Vikash Parajuli on 29/01/2021.
 * vparajuli819@gmail.com
 */
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRetrofitBinding
    private lateinit var viewModel: MainActivityViewModel

    private lateinit var adapter: MyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_retrofit)

        val factory = ViewModelFactory(application, NewsRepository())
        viewModel = ViewModelProvider(this, factory).get(MainActivityViewModel::class.java)

        initRecyclerView()
        getNews()
    }

    private fun initRecyclerView() {
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = MyAdapter()
        binding.recyclerView.adapter = adapter
    }

    private fun getNews() {
        viewModel.newsData.observe(this, {
            when (it) {
                is Resource.Loading -> showProgressBar()
                is Resource.Success ->{
                    hideProgressBar()
                    it.data?.let {
                        adapter.setList(it)
                    }
                }
                is Resource.Error -> {
                    hideProgressBar()
                    it.message?.let {
                        Toast.makeText(applicationContext, it, Toast.LENGTH_SHORT).show()
                    }
                }
            }
        })
    }

    private fun hideProgressBar() {
        binding.progressBar.visibility = View.GONE
    }

    private fun showProgressBar() {
        binding.progressBar.visibility = View.VISIBLE
    }
}