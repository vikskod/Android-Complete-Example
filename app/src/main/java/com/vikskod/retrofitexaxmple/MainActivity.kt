package com.vikskod.retrofitexaxmple

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.example.sampledatabinding.R
import com.vikskod.retrofitexaxmple.model.News
import com.vikskod.retrofitexaxmple.network.NewsService
import com.vikskod.retrofitexaxmple.network.RetrofitInstance
import retrofit2.Response


/**
 * Created by Vikash Parajuli on 29/01/2021.
 * vparajuli819@gmail.com
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_retrofit)

        val retrofitService = RetrofitInstance.getRetrofitInstance().create(NewsService::class.java)
        val responseLiveData: LiveData<Response<News>> = liveData {
            val response = retrofitService.getNews("8344b549554d443c964d5617a285debb", "au")
            emit(response)
        }

        responseLiveData.observe(this, {
            Log.i("Response ===", it.body().toString())
        })
    }
}