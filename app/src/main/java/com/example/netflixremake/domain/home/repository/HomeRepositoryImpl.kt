package com.example.netflixremake.domain.home.repository

import com.example.netflixremake.data.remote.home.HomeRemoteDataSource

class HomeRepositoryImpl(private val homeRemoteDataSource: HomeRemoteDataSource) : HomeRepository {

    override fun getCategories() = homeRemoteDataSource.getCategories()

    override fun logout() = homeRemoteDataSource.logout()
}