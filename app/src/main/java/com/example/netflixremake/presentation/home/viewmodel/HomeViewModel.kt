package com.example.netflixremake.presentation.home.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.netflixremake.base.BaseViewModel
import com.example.netflixremake.data.model.Category
import com.example.netflixremake.domain.home.usecase.HomeUseCase
import com.example.netflixremake.domain.movies.usecase.NetflixUseCase
import com.example.netflixremake.extension.onError
import com.example.netflixremake.extension.onSuccess
import kotlinx.coroutines.launch

class HomeViewModel(private val homeUseCase: HomeUseCase) : BaseViewModel() {

    private val _onCategoriesSuccess = MutableLiveData<Category?>()
    val onCategoriesResult: LiveData<Category?> = _onCategoriesSuccess

    private val _onUserLogout = MutableLiveData<Boolean>()
    val onLogoutResult : LiveData<Boolean> = _onUserLogout

    fun getCategories() = launch {
        homeUseCase.getCategories().onError {
            _onCategoriesSuccess.postValue(null)
            Log.d("TESTE", error(it))
        }.onSuccess {
            _onCategoriesSuccess.postValue(it)
        }
    }

    fun logoutUser() = launch {
        homeUseCase.logout().onError {
            _onUserLogout.postValue(false)
        }.onSuccess {
            _onUserLogout.postValue(true)
        }
    }

}