package com.pce.android.track20

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.dsl.module

class Track20Application : Application() {

    private val appModule = module {}

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@Track20Application)
            modules(appModule)
        }
    }
}