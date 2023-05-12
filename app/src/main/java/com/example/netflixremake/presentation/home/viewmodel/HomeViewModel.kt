package com.example.netflixremake.presentation.home.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.netflixremake.R
import com.example.netflixremake.base.BaseViewModel
import com.example.netflixremake.data.model.Category
import com.example.netflixremake.data.model.Movie
import com.example.netflixremake.domain.usecase.NetflixUseCase
import com.example.netflixremake.extension.onError
import com.example.netflixremake.extension.onSuccess
import kotlinx.coroutines.launch

class HomeViewModel(private val netflixUseCase: NetflixUseCase) : BaseViewModel() {

    private val _onCategoriesSuccess = MutableLiveData<List<Category>?>()
    val onCategoriesResult : LiveData<List<Category>?> = _onCategoriesSuccess


    fun mockMovies(): List<Movie> {
        return listOf(
            Movie(1, R.drawable.movie_4),
            Movie(1,R.drawable.placeholder_bg),
            Movie(1,R.drawable.movie),
            Movie(1,R.drawable.placeholder_bg),
            Movie(1,R.drawable.placeholder_bg),
            Movie(1,R.drawable.movie_4),
            Movie(1,R.drawable.movie),
        )
    }

    fun mockCategories(): List<Category> {
        return listOf(
            Category(1,"Nome da categoria1", mockMovies()),
            Category(1,"Nome da categoria2", mockMovies()),
            Category(1,"Nome da categoria3", mockMovies()),
            Category(1,"Nome da categoria4", mockMovies()),
            Category(1,"Nome da categoria4", mockMovies()),
            Category(1,"Nome da categoria4", mockMovies()),
        )
    }

    fun getCategories() =launch {
        val body = mockCategories()
        netflixUseCase.getCategories(body).onError {
            _onCategoriesSuccess.postValue(null)
            Log.d("TESTE", error(it))
        }.onSuccess {
            _onCategoriesSuccess.postValue(it)
        }
    }
}