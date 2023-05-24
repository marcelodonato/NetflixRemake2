package com.example.netflixremake.di

import com.example.netflixremake.data.remote.register.RegisterRemoteDataSource
import com.example.netflixremake.domain.register.repository.RegisterRepository
import com.example.netflixremake.domain.register.repository.RegisterRepositoryImpl
import com.example.netflixremake.domain.register.usecase.RegisterUseCase
import com.example.netflixremake.domain.register.usecase.RegisterUseCaseImpl
import com.example.netflixremake.presentation.register.viewmodel.RegisterViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module

val registerModule = module {
    viewModel { RegisterViewModel(get()) }
}

val  registerUseCase = module {
    single<RegisterUseCase> { RegisterUseCaseImpl(get()) }
}

val  registerDataSource = module {
    single { RegisterRemoteDataSource() }
}

val  registerRepository = module {
    single<RegisterRepository> { RegisterRepositoryImpl(get()) }
}

object RegisterInitializer {
    fun init() = loadKoinModules(listOf(registerModule, registerUseCase, registerDataSource, registerRepository))
}