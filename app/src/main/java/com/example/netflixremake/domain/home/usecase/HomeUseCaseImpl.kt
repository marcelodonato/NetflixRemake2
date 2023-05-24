package com.example.netflixremake.domain.home.usecase

import com.example.netflixremake.domain.home.repository.HomeRepository

class HomeUseCaseImpl(private val homeRepository: HomeRepository) : HomeUseCase {
    override suspend fun logout() = homeRepository.logout()

    override suspend fun getCategories() = homeRepository.getCategories()
}