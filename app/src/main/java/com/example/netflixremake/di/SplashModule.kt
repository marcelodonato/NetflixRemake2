package com.example.netflixremake.di

import com.example.netflixremake.data.remote.splash.SplashRemoteDataSource
import com.example.netflixremake.domain.splash.repository.SplashRepository
import com.example.netflixremake.domain.splash.repository.SplashRepositoryImpl
import com.example.netflixremake.domain.splash.usecase.SplashUseCase
import com.example.netflixremake.domain.splash.usecase.SplashUseCaseImpl
import com.example.netflixremake.presentation.splash.viewmodel.SplashViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module

val splashModule = module {
    viewModel { SplashViewModel(get()) }
}

val splashUseCase = module {
    single<SplashUseCase> { SplashUseCaseImpl(get()) }
}

val splashDataSource = module {
    single { SplashRemoteDataSource() }
}

val splashRepository = module {
    single<SplashRepository> { SplashRepositoryImpl(get()) }
}

object SplashInitializer {
    fun init() =
        loadKoinModules(listOf(splashModule, splashUseCase, splashDataSource, splashRepository))
}