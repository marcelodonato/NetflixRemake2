package com.example.netflixremake.presentation.splash.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.netflixremake.base.BaseViewModel
import com.example.netflixremake.domain.splash.usecase.SplashUseCase
import com.example.netflixremake.extension.onError
import com.example.netflixremake.extension.onSuccess
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.launch

class SplashViewModel(private val splashUseCase: SplashUseCase) : BaseViewModel() {

    private val _onVerifySuccess = MutableLiveData<Boolean>()
    val onVerifyResult: LiveData<Boolean> = _onVerifySuccess

      fun checkConnected() = launch {
         splashUseCase.verify().onError {
             _onVerifySuccess.postValue(true)
         }.onSuccess {response ->
             if(response){
                 _onVerifySuccess.postValue(true)
             } else{
                 _onVerifySuccess.postValue(false)
             }

         }


    }
}