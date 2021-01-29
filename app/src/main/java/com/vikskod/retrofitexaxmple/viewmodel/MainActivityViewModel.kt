package com.vikskod.retrofitexaxmple.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sampledatabinding.R
import com.vikskod.retrofitexaxmple.model.News
import com.vikskod.retrofitexaxmple.repository.NewsRepository
import com.vikskod.retrofitexaxmple.utils.Resource
import com.vikskod.retrofitexaxmple.utils.Util.hasInternetConnection
import kotlinx.coroutines.launch
import retrofit2.Response
import java.io.IOException


/**
 * Created by Vikash Parajuli on 29/01/2021.
 * vparajuli819@gmail.com
 */
class MainActivityViewModel(
    val app: Application,
    private val appRepository: NewsRepository
) : ViewModel() {

    val newsData: MutableLiveData<Resource<News>> = MutableLiveData()

    init {
        getNews()
    }

    private fun getNews() = viewModelScope.launch {
        fetchNews()
    }

    private suspend fun fetchNews() {
        newsData.postValue(Resource.Loading())
        try {
            if (hasInternetConnection(app)) {
                val response = appRepository.getNews()
                newsData.postValue(handleNewsResponse(response))
            } else {
                newsData.postValue(Resource.Error(app.getString(R.string.no_internet)))
            }
        } catch (t: Throwable) {
            when (t) {
                is IOException -> newsData.postValue(
                    Resource.Error(app.getString(R.string.network_failure))
                )

                else -> {
                    Log.e("Response ===", "Error ${t.message}")
                    newsData.postValue(
                        Resource.Error(app.getString(R.string.conversion_error))
                    )
                }
            }
        }
    }

    private fun handleNewsResponse(response: Response<News>): Resource<News> {
        if (response.isSuccessful) {
            response.body()?.let { resultResponse ->
                return Resource.Success(resultResponse)
            }
        }
        return Resource.Error(response.message())
    }

}