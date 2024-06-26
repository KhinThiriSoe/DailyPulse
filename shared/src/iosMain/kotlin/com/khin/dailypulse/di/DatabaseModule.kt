package com.khin.dailypulse.di

import app.cash.sqldelight.db.SqlDriver
import com.khin.dailypulse.db.DailyPulseDatabase
import com.khin.dailypulse.db.DatabaseDriverFactory
import org.koin.dsl.module

val databaseModule = module {
    single<SqlDriver> {
        DatabaseDriverFactory().createDriver()!!
    }

    single<DailyPulseDatabase> {
        DailyPulseDatabase(get())
    }
}