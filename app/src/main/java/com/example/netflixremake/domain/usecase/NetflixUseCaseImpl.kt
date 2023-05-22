package com.example.netflixremake.domain.usecase

import com.example.netflixremake.domain.repository.NetflixRepository

class NetflixUseCaseImpl(private val netflixRepository: NetflixRepository) : NetflixUseCase {
    override suspend fun getCategories() = netflixRepository.getCategories()
    override suspend fun getMovieDetails(body : String?) = netflixRepository.getMovieDetails(body)
}