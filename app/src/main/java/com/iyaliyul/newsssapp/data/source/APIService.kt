package com.iyaliyul.newsssapp.data.source

import com.iyaliyul.newsssapp.data.model.ResponseNews
import com.iyaliyul.newsssapp.data.repository.NewsRepository
import retrofit2.http.GET
import retrofit2.http.Query

interface APIService {

    @GET("top-headlines")
    suspend fun fetchNews(
        @Query("country") country: String,
        @Query("category") category: String,
        @Query("apiKey") apikey: String
    ): ResponseNews
}