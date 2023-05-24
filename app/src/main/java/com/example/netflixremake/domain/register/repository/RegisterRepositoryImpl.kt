package com.example.netflixremake.domain.register.repository

import com.example.netflixremake.data.remote.register.RegisterRemoteDataSource

class RegisterRepositoryImpl(private val registerRemoteDataSource: RegisterRemoteDataSource) :
    RegisterRepository {
    override fun register(login: String, password: String) =
        registerRemoteDataSource.register(login, password)
}