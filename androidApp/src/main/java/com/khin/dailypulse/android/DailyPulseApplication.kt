package com.khin.dailypulse.android

import android.app.Application
import com.khin.dailypulse.android.di.databaseModule
import com.khin.dailypulse.android.di.viewModelModule
import com.khin.dailypulse.di.sharedKoinModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class DailyPulseApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    private fun initKoin() {
        val modules = sharedKoinModule + viewModelModule + databaseModule
        startKoin {
            androidContext(this@DailyPulseApplication)
            modules(modules)
        }
    }
}