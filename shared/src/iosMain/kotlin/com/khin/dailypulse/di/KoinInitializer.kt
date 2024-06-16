package com.khin.dailypulse.di

import com.khin.dailypulse.articles.presentation.ArticlesViewModel
import com.khin.dailypulse.sources.presentation.SourcesViewModel
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.context.startKoin

fun initKoin() {
    val module = sharedKoinModule + databaseModule

    startKoin {
        modules(module)
    }
}

class ArticlesInjector: KoinComponent {

    val articlesViewModel: ArticlesViewModel by inject()
}

class SourcesInjector: KoinComponent {

    val sourcesViewModel: SourcesViewModel by inject()
}