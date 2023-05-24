package com.example.netflixremake.domain.splash.repository

import com.example.netflixremake.data.remote.splash.SplashRemoteDataSource

class SplashRepositoryImpl(private val splashRemoteDataSource: SplashRemoteDataSource) : SplashRepository {
    override fun verify() = splashRemoteDataSource.verify()
}