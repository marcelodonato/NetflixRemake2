package com.example.netflixremake.data.remote.login

import com.example.netflixremake.base.BaseDataSource
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.flow.Flow
import javax.security.auth.login.LoginException

class LoginRemoteDataSource : BaseDataSource() {
    fun login(login: String, password: String): Flow<Unit> = call {
        val firebase = FirebaseAuth.getInstance()
        firebase.signInWithEmailAndPassword(login, password)
    }
}