package com.example.netflixremake.data.remote

import com.example.netflixremake.base.BaseDataSource
import com.example.netflixremake.data.model.Category
import kotlinx.coroutines.flow.Flow

class NetflixRemoteDataSource(private val api: NetflixAPI) : BaseDataSource() {

    fun getCategories(body: Category) : Flow<Category> = callApi {
        api.getCategories(body)
    }
}