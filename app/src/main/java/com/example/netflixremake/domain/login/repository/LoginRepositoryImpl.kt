package com.example.netflixremake.domain.login.repository

import com.example.netflixremake.data.remote.login.LoginRemoteDataSource

class LoginRepositoryImpl(private val loginRemoteDataSource: LoginRemoteDataSource) :
    LoginRepository {
    override fun login(login: String, password: String) =
        loginRemoteDataSource.login(login, password)
}