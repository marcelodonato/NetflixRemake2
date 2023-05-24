package com.example.netflixremake.domain.movies.usecase

import com.example.netflixremake.domain.movies.repository.NetflixRepository

class NetflixUseCaseImpl(private val netflixRepository: NetflixRepository) : NetflixUseCase {
    override suspend fun getMovieDetails(body : String?) = netflixRepository.getMovieDetails(body)
}