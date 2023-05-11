package com.example.netflixremake

import android.app.Application
import com.example.netflixremake.di.dataSource
import com.example.netflixremake.di.netflixModule
import com.example.netflixremake.di.repository
import com.example.netflixremake.di.securityModule
import com.example.netflixremake.di.useCase
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class NetflixApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@NetflixApplication)
            modules( securityModule)
        }
    }
}