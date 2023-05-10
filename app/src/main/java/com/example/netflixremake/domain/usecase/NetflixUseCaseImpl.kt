package com.example.netflixremake.domain.usecase

import com.example.netflixremake.data.model.Category
import com.example.netflixremake.domain.repository.NetflixRepository
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import java.util.*

class NetflixUseCaseImpl(private val netflixRepository: NetflixRepository) : NetflixUseCase {
    override suspend fun getCategories() = flow {
        val body = Category("", emptyList())
        netflixRepository.getCategories(body).collect{
            emit(it)
        }
    }
}