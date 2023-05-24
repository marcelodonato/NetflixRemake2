package com.example.netflixremake.data.remote.splash

import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow

class SplashRemoteDataSource {

    fun verify(): Flow<Boolean> = callbackFlow {
        val user = FirebaseAuth.getInstance().currentUser
        trySend(user != null)
        awaitClose()
    }
}