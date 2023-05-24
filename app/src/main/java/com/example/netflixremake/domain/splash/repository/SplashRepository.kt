package com.example.netflixremake.domain.splash.repository

import kotlinx.coroutines.flow.Flow

interface SplashRepository {
    fun verify() : Flow<Boolean>
}