package com.example.kmptemplate.android

import android.app.Application
import com.example.kmptemplate.android.di.viewModelModule
import com.example.kmptemplate.di.initKoin
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.logger.Level

class App: Application(){

    override fun onCreate() {
        super.onCreate()

        initKoin{
            androidLogger(if (BuildConfig.LOG_MODE) Level.ERROR else Level.NONE)
            androidContext(this@App)
            modules(
                viewModelModule
            )
        }
    }
}