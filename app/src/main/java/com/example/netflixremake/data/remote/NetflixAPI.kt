package com.example.netflixremake.data.remote


import com.example.netflixremake.data.model.BaseResponseModel
import com.example.netflixremake.data.model.Category
import com.example.netflixremake.security.data.SecurityConstants
import com.google.android.gms.common.api.internal.ApiKey
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface NetflixAPI {

    companion object {
        const val HOME = "home"
    }

    @GET(HOME)
    suspend fun getCategories(@Body body: List<Category>): BaseResponseModel<List<Category>>
}