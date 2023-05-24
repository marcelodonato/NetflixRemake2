package com.example.netflixremake.data.remote.register

import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import javax.security.auth.login.LoginException

class RegisterRemoteDataSource {

    fun register(login: String, password: String): Flow<Unit> = callbackFlow {

        FirebaseAuth.getInstance().createUserWithEmailAndPassword(login, password)
            .addOnCompleteListener {
                if (!it.isSuccessful) {
                    close(LoginException("Erro ao tentar se cadastrar."))
                } else {
                    trySend(Unit)
                }
            }
        awaitClose()
    }
}