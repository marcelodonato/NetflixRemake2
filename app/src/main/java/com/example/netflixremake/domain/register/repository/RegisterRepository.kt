package com.example.netflixremake.domain.register.repository

import kotlinx.coroutines.flow.Flow

interface RegisterRepository {
    fun register(login: String, password: String): Flow<Unit>
}