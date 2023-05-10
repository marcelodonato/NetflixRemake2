package com.example.netflixremake.data.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL = "https://api.tiagoaguiar.co/netflixapp/"
private const val API_KEY = "?apiKey=9d2b4c4c-d75b-4ef8-9445-24142894f330"


object HTTPClient {
    fun retrofit() = Retrofit.Builder()
        .baseUrl(BASE_URL + API_KEY)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

}