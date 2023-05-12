package com.example.netflixremake.domain.usecase

import com.example.netflixremake.data.model.Category
import kotlinx.coroutines.flow.Flow

interface NetflixUseCase {
    suspend fun getCategories(body: List<Category>): Flow<List<Category>>
}