package com.example.netflixremake.di

import com.example.netflixremake.data.remote.NetflixAPI
import com.example.netflixremake.data.remote.NetflixRemoteDataSource
import com.example.netflixremake.domain.repository.NetflixRepository
import com.example.netflixremake.domain.repository.NetflixRepositoryImpl
import com.example.netflixremake.domain.usecase.NetflixUseCase
import com.example.netflixremake.domain.usecase.NetflixUseCaseImpl
import com.example.netflixremake.extension.getRetrofit
import com.example.netflixremake.presentation.home.viewmodel.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module

val netflixModule = module {
    viewModel { HomeViewModel(get()) }
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
    fun init() = loadKoinModules(listOf(netflixModule, useCase, dataSource, repository, api))
}