package com.example.netflixremake.domain.register.usecase

import com.example.netflixremake.domain.register.repository.RegisterRepository

class RegisterUseCaseImpl(private val registerRepository: RegisterRepository) : RegisterUseCase {
    override suspend fun register(login: String, password: String) = registerRepository.register(login, password)
}