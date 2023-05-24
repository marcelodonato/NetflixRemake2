package com.example.netflixremake.presentation.register.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.netflixremake.base.BaseViewModel
import com.example.netflixremake.domain.register.usecase.RegisterUseCase
import com.example.netflixremake.extension.onError
import com.example.netflixremake.extension.onSuccess
import kotlinx.coroutines.launch

class RegisterViewModel(private val loginUseCase: RegisterUseCase) : BaseViewModel() {

    private val _onRegisterSuccess = MutableLiveData<Boolean>()
    val onRegisterResult: LiveData<Boolean> = _onRegisterSuccess


    fun registerToFirebase(login: String, password: String) = launch {
        loginUseCase.register(login, password).onError {
            _onRegisterSuccess.postValue(false)
            Log.d("Teste", it.message.orEmpty())
        }.onSuccess {
            _onRegisterSuccess.postValue(true)
        }
    }
}