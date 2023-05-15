package com.example.netflixremake.domain.repository

import com.example.netflixremake.data.model.Category
import kotlinx.coroutines.flow.Flow


interface NetflixRepository {

    fun getCategories(): Flow<Category>
}