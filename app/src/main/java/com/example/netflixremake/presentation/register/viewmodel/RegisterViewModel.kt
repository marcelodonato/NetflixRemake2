package com.example.netflixremake.presentation.register.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.netflixremake.base.BaseViewModel
import com.google.firebase.auth.FirebaseAuth

class RegisterViewModel : BaseViewModel() {


    private val _onRegisterSuccess = MutableLiveData<Boolean>()
    val onRegisterResult: LiveData<Boolean> = _onRegisterSuccess

    fun registerToFirebase(email: String, password: String) {
        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener {
                _onRegisterSuccess.value = it.isSuccessful
            }
    }
}