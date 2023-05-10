package com.example.netflixremake.data.remote


import com.example.netflixremake.data.model.BaseResponseModel
import com.example.netflixremake.data.model.Category
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET

interface NetflixAPI {

    companion object {
        const val HOME = "home"
    }

    @GET(HOME)
    suspend fun getCategories(@Body body: Category): BaseResponseModel<Category>
}