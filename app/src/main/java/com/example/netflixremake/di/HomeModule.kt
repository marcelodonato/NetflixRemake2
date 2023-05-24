package com.example.netflixremake.di

import com.example.netflixremake.data.remote.NetflixAPI
import com.example.netflixremake.data.remote.home.HomeAPI
import com.example.netflixremake.data.remote.home.HomeRemoteDataSource
import com.example.netflixremake.domain.home.repository.HomeRepository
import com.example.netflixremake.domain.home.repository.HomeRepositoryImpl
import com.example.netflixremake.domain.home.usecase.HomeUseCase
import com.example.netflixremake.domain.home.usecase.HomeUseCaseImpl
import com.example.netflixremake.extension.getRetrofit
import com.example.netflixremake.presentation.home.viewmodel.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module

val homeModule = module {
    viewModel { HomeViewModel(get()) }
}

val homeUseCase = module {
    single<HomeUseCase> { HomeUseCaseImpl(get()) }
}

val homeDataSource = module {
    single { HomeRemoteDataSource(get()) }
}

val homeRepository = module {
    single<HomeRepository> { HomeRepositoryImpl(get()) }
}

val homeApi = module {
    single<HomeAPI> { getRetrofit().create(HomeAPI::class.java) }
}

object HomeInitializer {
    fun init() =
        loadKoinModules(listOf(homeModule, homeUseCase, homeDataSource, homeApi, homeRepository))
}