package com.example.netflixremake.domain.movies.repository

import com.example.netflixremake.data.remote.NetflixRemoteDataSource

class NetflixRepositoryImpl(private val netflixRemoteDataSource: NetflixRemoteDataSource) :
    NetflixRepository {

    override fun getMovieDetails(body : String?) = netflixRemoteDataSource.getMovieDetails(body)
}