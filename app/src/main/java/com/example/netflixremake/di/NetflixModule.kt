package com.example.netflixremake.di

import com.example.netflixremake.data.remote.NetflixAPI
import com.example.netflixremake.data.remote.NetflixRemoteDataSource
import com.example.netflixremake.domain.movies.repository.NetflixRepository
import com.example.netflixremake.domain.movies.repository.NetflixRepositoryImpl
import com.example.netflixremake.domain.movies.usecase.NetflixUseCase
import com.example.netflixremake.domain.movies.usecase.NetflixUseCaseImpl
import com.example.netflixremake.extension.getRetrofit
import com.example.netflixremake.presentation.home.viewmodel.HomeViewModel
import com.example.netflixremake.presentation.movie.viewModel.MovieDetailsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module


val netflixModule = module {
    viewModel { MovieDetailsViewModel(get()) }
}

val useCase = module {
    single<NetflixUseCase> { NetflixUseCaseImpl(get()) }
}

val dataSource = module {
    single { NetflixRemoteDataSource(get()) }
}

val repository = module {
    single<NetflixRepository> { NetflixRepositoryImpl(get()) }
}

val api = module {
    single<NetflixAPI> { getRetrofit().create(NetflixAPI::class.java) }
}

object NetflixInitializer {
    fun init() = loadKoinModules(listOf(netflixModule, api, useCase, dataSource, repository))
}