package com.example.netflixremake.presentation.login.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.netflixremake.base.BaseViewModel
import com.example.netflixremake.domain.login.usecase.LoginUseCase
import com.example.netflixremake.extension.onError
import com.example.netflixremake.extension.onSuccess
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.launch

class LoginViewModel(private val loginUseCase: LoginUseCase) : BaseViewModel() {

    private val _onLoginSuccess = MutableLiveData<Boolean>()
    val onLoginResult: LiveData<Boolean> = _onLoginSuccess

    fun login(login: String, password: String) = launch {
        loginUseCase.login(login, password).onError {
            _onLoginSuccess.postValue(false)
        }.onSuccess {
            _onLoginSuccess.postValue(true)
        }
    }

    fun loginFirebase(email: String, password: String) {
        val firebase = FirebaseAuth.getInstance()
        firebase.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener {
                _onLoginSuccess.postValue(it.isSuccessful)
            }
    }
}