package com.example.streamverse

import android.app.Application
import com.example.streamverse.di.appModule
import com.example.streamverse.di.networkModule
import com.example.streamverse.di.repositoryModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class WatchApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@WatchApplication)
            modules(appModule, networkModule, repositoryModule)
        }
    }
}