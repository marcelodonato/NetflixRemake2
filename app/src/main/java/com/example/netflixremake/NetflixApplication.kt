package com.example.netflixremake

import android.app.Application
import com.example.netflixremake.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class NetflixApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@NetflixApplication)
            modules(securityModule)
            SplashInitializer.init()
            HomeInitializer.init()
            NetflixInitializer.init()
            LoginInitializer.init()
            RegisterInitializer.init()
        }
    }
}