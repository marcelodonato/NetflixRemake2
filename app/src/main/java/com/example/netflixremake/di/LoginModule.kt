package com.example.netflixremake.di

import com.example.netflixremake.data.remote.login.LoginRemoteDataSource
import com.example.netflixremake.domain.login.repository.LoginRepository
import com.example.netflixremake.domain.login.repository.LoginRepositoryImpl
import com.example.netflixremake.domain.login.usecase.LoginUseCase
import com.example.netflixremake.domain.login.usecase.LoginUseCaseImpl
import com.example.netflixremake.presentation.login.viewmodel.LoginViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module

val loginModule = module {
    viewModel { LoginViewModel(get()) }
}

val loginUseCase = module {
    single<LoginUseCase> { LoginUseCaseImpl(get()) }
}

val loginDataSource = module {
    single { LoginRemoteDataSource() }
}

val loginRepository = module {
    single<LoginRepository> { LoginRepositoryImpl(get()) }
}

object LoginInitializer {
    fun init() =
        loadKoinModules(listOf(loginModule, loginUseCase, loginDataSource, loginRepository))
}