package com.example.netflixremake.domain.repository

import com.example.netflixremake.data.remote.NetflixRemoteDataSource

class NetflixRepositoryImpl(private val netflixRemoteDataSource: NetflixRemoteDataSource) :
    NetflixRepository {

    override fun getCategories() = netflixRemoteDataSource.getCategories()
    override fun getMovieDetails(body : String?) = netflixRemoteDataSource.getMovieDetails(body)
}