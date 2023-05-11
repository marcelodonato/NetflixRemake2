package com.example.netflixremake.domain.repository

import com.example.netflixremake.data.model.Category
import com.example.netflixremake.data.remote.NetflixRemoteDataSource

class NetflixRepositoryImpl(private val netflixRemoteDataSource: NetflixRemoteDataSource) :
    NetflixRepository {

    override fun getCategories(body: List<Category>) = netflixRemoteDataSource.getCategories(body)
}