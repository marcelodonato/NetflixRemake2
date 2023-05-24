package com.example.netflixremake.domain.splash.usecase

import kotlinx.coroutines.flow.Flow


interface SplashUseCase {
    suspend fun verify() : Flow<Boolean>
}