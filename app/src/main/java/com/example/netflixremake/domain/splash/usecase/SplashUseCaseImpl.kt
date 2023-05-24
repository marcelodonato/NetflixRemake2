package com.example.netflixremake.domain.splash.usecase

import com.example.netflixremake.domain.splash.repository.SplashRepository
import kotlinx.coroutines.flow.Flow

class SplashUseCaseImpl(private val splashRepository: SplashRepository): SplashUseCase {
    override suspend fun verify() = splashRepository.verify()
}