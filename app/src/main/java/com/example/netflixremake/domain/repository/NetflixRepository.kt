package com.example.netflixremake.domain.repository

import com.example.netflixremake.data.model.Category
import com.example.netflixremake.data.model.MovieDetails
import kotlinx.coroutines.flow.Flow

interface NetflixRepository {
    fun getCategories(): Flow<Category>
    fun getMovieDetails(body : String?): Flow<MovieDetails>
}