package com.example.netflixremake.domain.movies.repository

import com.example.netflixremake.data.model.Category
import com.example.netflixremake.data.model.MovieDetails
import kotlinx.coroutines.flow.Flow

interface NetflixRepository {
    fun getMovieDetails(body : String?): Flow<MovieDetails>
}