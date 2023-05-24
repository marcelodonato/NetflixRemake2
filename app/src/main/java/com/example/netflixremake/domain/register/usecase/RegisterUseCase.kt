package com.example.netflixremake.domain.register.usecase

import kotlinx.coroutines.flow.Flow

interface RegisterUseCase {
    suspend fun register(login: String, password: String): Flow<Unit>
}