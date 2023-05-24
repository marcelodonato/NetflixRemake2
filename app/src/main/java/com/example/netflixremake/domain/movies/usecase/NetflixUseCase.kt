package com.example.netflixremake.domain.movies.usecase

import com.example.netflixremake.data.model.Category
import com.example.netflixremake.data.model.MovieDetails
import kotlinx.coroutines.flow.Flow

interface NetflixUseCase {
    suspend fun getMovieDetails(body : String?): Flow<MovieDetails>
}