package com.example.netflixremake.data.remote


import com.example.netflixremake.data.model.BaseResponseModel
import com.example.netflixremake.data.model.Category
import com.example.netflixremake.security.data.SecurityConstants.API_KEY
import retrofit2.http.GET
import retrofit2.http.Query

interface NetflixAPI {

    companion object {
        const val HOME = "home"
    }

    @GET(HOME)
    suspend fun getCategories(@Query("apiKey") apiKey: String = API_KEY): BaseResponseModel<Category>
}