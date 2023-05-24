package com.example.netflixremake

import android.app.Application
import com.example.netflixremake.di.LoginInitializer
import com.example.netflixremake.di.NetflixInitializer
import com.example.netflixremake.di.securityModule
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
            NetflixInitializer.init()
            LoginInitializer.init()
        }
    }
}