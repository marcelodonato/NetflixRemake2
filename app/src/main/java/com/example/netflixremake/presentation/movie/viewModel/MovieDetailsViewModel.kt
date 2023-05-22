package com.example.netflixremake.presentation.movie.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.netflixremake.base.BaseViewModel
import com.example.netflixremake.data.model.MovieDetails
import com.example.netflixremake.domain.usecase.NetflixUseCase
import com.example.netflixremake.extension.onError
import com.example.netflixremake.extension.onSuccess
import kotlinx.coroutines.launch

class MovieDetailsViewModel(private val netflixUseCase: NetflixUseCase) : BaseViewModel() {

    private val _onDetailsSuccess = MutableLiveData<MovieDetails?>()
    val onDetailsResult: LiveData<MovieDetails?> = _onDetailsSuccess

    fun getMovieDetails(id: String? = null) = launch {

        netflixUseCase.getMovieDetails(id).onError {
            _onDetailsSuccess.postValue(null)
            Log.d("TESTE", error(it))
        }.onSuccess {
            _onDetailsSuccess.postValue(it)
        }
    }
}