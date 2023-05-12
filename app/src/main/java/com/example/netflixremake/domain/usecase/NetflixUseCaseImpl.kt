package com.example.netflixremake.domain.usecase

import com.example.netflixremake.data.model.Category
import com.example.netflixremake.domain.repository.NetflixRepository

class NetflixUseCaseImpl(private val netflixRepository: NetflixRepository) : NetflixUseCase {
    override suspend fun getCategories(body: List<Category>) = netflixRepository.getCategories(body)
}