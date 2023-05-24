package com.example.netflixremake.data.remote


import com.example.netflixremake.data.model.Category
import com.example.netflixremake.data.model.MovieDetails
import com.example.netflixremake.security.data.SecurityConstants.API_KEY
import org.koin.core.component.getScopeId
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface NetflixAPI {

    companion object {

        const val MOVIE_DETAILS = "movie/{id}"
    }


    @GET(MOVIE_DETAILS)
    suspend fun getMovieDetails(@Path("id") id: String? = null ,@Query("apiKey") apiKey: String =  API_KEY): MovieDetails
}