package com.example.netflixremake.data.remote

import com.example.netflixremake.base.BaseDataSource
import com.example.netflixremake.data.model.Category
import com.example.netflixremake.data.model.MovieDetails
import kotlinx.coroutines.flow.Flow

class NetflixRemoteDataSource(private val api: NetflixAPI) : BaseDataSource() {

    fun getMovieDetails(body : String?): Flow<MovieDetails> =
        call { api.getMovieDetails(id = body) }
}