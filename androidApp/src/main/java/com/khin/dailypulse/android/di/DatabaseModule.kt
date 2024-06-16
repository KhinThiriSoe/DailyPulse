package com.khin.dailypulse.android.di

import app.cash.sqldelight.db.SqlDriver
import com.khin.dailypulse.db.DailyPulseDatabase
import com.khin.dailypulse.db.DatabaseDriverFactory
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val databaseModule = module {
    single<SqlDriver> {
        DatabaseDriverFactory(androidContext()).createDriver()
    }

    single<DailyPulseDatabase> {
        DailyPulseDatabase(get())
    }
}