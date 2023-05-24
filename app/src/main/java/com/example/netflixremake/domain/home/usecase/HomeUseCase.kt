package com.example.netflixremake.domain.home.usecase

import com.example.netflixremake.data.model.Category
import kotlinx.coroutines.flow.Flow

interface HomeUseCase {
    suspend fun getCategories(): Flow<Category>

    suspend fun logout(): Flow<Boolean>
}