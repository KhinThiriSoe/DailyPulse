package com.khin.dailypulse.di

import org.koin.core.context.startKoin

fun initKoin() = startKoin {
    modules(sharedKoinModule + databaseModule)
}.koin