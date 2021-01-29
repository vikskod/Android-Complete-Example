package com.vikskod.retrofitexaxmple.network

import com.vikskod.retrofitexaxmple.model.News
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query


/**
 * Created by Vikash Parajuli on 29/01/2021.
 * vparajuli819@gmail.com
 */
interface NewsService {

    @GET("/v2/top-headlines")
    suspend fun getNews(
        @Header("Authorization") auth: String,
        @Query("country") country: String
    ): Response<News>
}