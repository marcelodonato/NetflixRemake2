package com.example.netflixremake.presentation.home.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.netflixremake.base.BaseViewModel
import com.example.netflixremake.data.model.Category
import com.example.netflixremake.domain.usecase.NetflixUseCase
import com.example.netflixremake.extension.onError
import com.example.netflixremake.extension.onSuccess
import kotlinx.coroutines.launch

class HomeViewModel(private val netflixUseCase: NetflixUseCase) : BaseViewModel() {

    private val _onCategoriesSuccess = MutableLiveData<Category?>()
    val onCategoriesResult: LiveData<Category?> = _onCategoriesSuccess


    fun getCategories() = launch {
        netflixUseCase.getCategories().onError {
            _onCategoriesSuccess.postValue(null)
            Log.d("TESTE", error(it))
        }.onSuccess {
            _onCategoriesSuccess.postValue(it)
        }
    }
}