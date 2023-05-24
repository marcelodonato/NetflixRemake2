package com.example.netflixremake.data.remote.login

import com.example.netflixremake.base.BaseDataSource
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.cancel
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.flow
import javax.security.auth.login.LoginException

class LoginRemoteDataSource : BaseDataSource() {
    fun login(login: String, password: String): Flow<Unit> = callbackFlow {
        val firebase = FirebaseAuth.getInstance()
        firebase.signInWithEmailAndPassword(login, password).addOnCompleteListener {
            if (!it.isSuccessful) {
                close(Exception("Login ou senha incorretos"))
            } else{
                trySend(Unit)
            }

        }
        awaitClose()
    }

}


