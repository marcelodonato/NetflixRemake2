package com.example.netflixremake.domain.home.repository

import com.example.netflixremake.data.model.Category
import kotlinx.coroutines.flow.Flow

interface HomeRepository {
    fun getCategories(): Flow<Category>

    fun logout() : Flow<Boolean>
}