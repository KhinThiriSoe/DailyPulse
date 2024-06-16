package com.khin.dailypulse.di

import com.khin.dailypulse.articles.di.articlesModule
import com.khin.dailypulse.sources.di.sourcesModule

val sharedKoinModule = listOf(
    networkModule,
    articlesModule,
    sourcesModule
)