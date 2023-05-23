package com.example.netflixremake.domain.login.repository

import kotlinx.coroutines.flow.Flow

interface LoginRepository {
    fun login(login: String, password: String): Flow<Unit>
}