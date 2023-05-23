package com.example.netflixremake.domain.login.usecase

import kotlinx.coroutines.flow.Flow

interface LoginUseCase {

    suspend fun login(login: String, password: String): Flow<Unit>

}