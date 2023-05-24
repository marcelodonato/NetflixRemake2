package com.example.netflixremake.data.remote.home

import com.example.netflixremake.data.model.Category
import com.example.netflixremake.security.data.SecurityConstants
import retrofit2.http.GET
import retrofit2.http.Query

interface HomeAPI {

    companion object {
        const val HOME = "home"
    }

    @GET(HOME)
    suspend fun getCategories(@Query("apiKey") apiKey: String = SecurityConstants.API_KEY): Category
}