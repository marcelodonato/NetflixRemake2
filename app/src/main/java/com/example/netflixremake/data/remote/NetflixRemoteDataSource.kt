package com.example.netflixremake.data.remote

import com.example.netflixremake.base.BaseDataSource
import com.example.netflixremake.data.model.Category
import kotlinx.coroutines.flow.Flow

class NetflixRemoteDataSource(private val api: NetflixAPI) : BaseDataSource() {

    fun getCategories(): Flow<Category> =
        call { api.getCategories() }
//        callApi {
//            api.getCategories()
//        }
}