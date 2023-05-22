package com.example.netflixremake.presentation.login.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.netflixremake.base.BaseViewModel
import com.google.firebase.auth.FirebaseAuth

class LoginViewModel : BaseViewModel() {

    private val _onLoginSuccess = MutableLiveData<Boolean>()
    val onLoginResult: LiveData<Boolean> = _onLoginSuccess


    fun loginFirebase(email: String, password: String) {
        val firebase = FirebaseAuth.getInstance()
        firebase.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener {
                _onLoginSuccess.value = it.isSuccessful
            }
    }
}