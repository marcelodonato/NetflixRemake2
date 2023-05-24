package com.example.netflixremake.data.remote.home

import com.example.netflixremake.base.BaseDataSource
import com.example.netflixremake.data.model.Category
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow

class HomeRemoteDataSource(private val api : HomeAPI) : BaseDataSource(){

    fun getCategories(): Flow<Category> =
        call { api.getCategories() }

    fun logout() : Flow<Boolean> = callbackFlow {
        val user = FirebaseAuth.getInstance()
        user.signOut()
        trySend(true)
        awaitClose()
    }
}