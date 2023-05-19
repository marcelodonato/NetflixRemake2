package com.example.netflixremake.di

import com.example.netflixremake.BuildConfig
import com.example.netflixremake.data.remote.NetflixAPI
import com.example.netflixremake.data.remote.NetflixRemoteDataSource
import com.example.netflixremake.domain.repository.NetflixRepository
import com.example.netflixremake.domain.repository.NetflixRepositoryImpl
import com.example.netflixremake.domain.usecase.NetflixUseCase
import com.example.netflixremake.domain.usecase.NetflixUseCaseImpl
import com.example.netflixremake.extension.getRetrofit
import com.example.netflixremake.presentation.home.viewmodel.HomeViewModel
import com.example.netflixremake.presentation.movie.viewModel.MovieDetailsViewModel
import com.example.netflixremake.presentation.register.viewmodel.RegisterViewModel
import com.example.netflixremake.security.data.SecurityConstants.BASE_URL
import com.example.netflixremake.security.data.SecurityConstants.CALL_TIMEOUT
import com.example.netflixremake.security.data.SecurityConstants.READ_TIMEOUT
import com.example.netflixremake.security.providers.ApiHeaders
import com.example.netflixremake.security.providers.ApiHeadersProvider
import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val netflixModule = module {
    viewModel { HomeViewModel(get()) }
    viewModel {MovieDetailsViewModel(get())}
    viewModel {RegisterViewModel()}
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

val securityModule = module {
    single<ApiHeaders> { ApiHeadersProvider() }


    fun provideGson(): Gson {
        return GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.IDENTITY).create()
    }

    fun provideHttpClient(): OkHttpClient {
        val logInterceptor = HttpLoggingInterceptor().apply {
            /**
             * Use Interceptor body only for debug local porpoises, because of a known bug of OkHttp, some requests with empty body response
             * is crashing requests and gives a false result with logging interceptor
             * **/
            level = if (BuildConfig.DEBUG) {
                HttpLoggingInterceptor.Level.BODY
            } else {
                HttpLoggingInterceptor.Level.NONE
            }
        }

        return OkHttpClient.Builder()
            .addInterceptor(logInterceptor)
            .callTimeout(CALL_TIMEOUT, TimeUnit.SECONDS)
            .readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
            .build()
    }

    fun provideRetrofit(factory: Gson, client: OkHttpClient): Retrofit {
        val baseUrl = BASE_URL
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create(factory))
            .client(client)
            .build()
    }

    single { provideGson() }
    single { provideHttpClient() }
    single { provideRetrofit(get(), get()) }

}

object NetflixInitializer {
    fun init() = loadKoinModules(listOf(netflixModule, api, useCase, dataSource, repository))
}