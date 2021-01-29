package com.vikskod.retrofitexaxmple.repository

import com.vikskod.retrofitexaxmple.network.RetrofitInstance
import com.vikskod.retrofitexaxmple.utils.Util.API_KEY
import com.vikskod.retrofitexaxmple.utils.Util.COUNTRY


/**
 * Created by Vikash Parajuli on 29/01/2021.
 * vparajuli819@gmail.com
 */
class NewsRepository {

    suspend fun getNews() = RetrofitInstance.newsApi.getNews(API_KEY, COUNTRY)
}