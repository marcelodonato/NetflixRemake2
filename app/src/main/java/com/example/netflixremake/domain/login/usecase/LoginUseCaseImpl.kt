package com.example.netflixremake.domain.login.usecase

import com.example.netflixremake.domain.login.repository.LoginRepository

class LoginUseCaseImpl(private val loginRepository: LoginRepository) : LoginUseCase {
    override suspend fun login(login: String, password: String) =
        loginRepository.login(login, password)
}