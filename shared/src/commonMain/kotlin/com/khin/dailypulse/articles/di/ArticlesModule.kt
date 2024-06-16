package com.khin.dailypulse.articles.di

import com.khin.dailypulse.articles.data.ArticlesDataSource
import com.khin.dailypulse.articles.data.ArticlesRepository
import com.khin.dailypulse.articles.data.ArticlesService
import com.khin.dailypulse.articles.domain.ArticlesUseCase
import com.khin.dailypulse.articles.presentation.ArticlesViewModel
import org.koin.dsl.module

val articlesModule = module {

    single<ArticlesService> { ArticlesService(get()) }
    single<ArticlesUseCase> { ArticlesUseCase(get()) }
    single<ArticlesViewModel> { ArticlesViewModel(get()) }
    single<ArticlesDataSource> { ArticlesDataSource(get()) }
    single<ArticlesRepository> { ArticlesRepository(get(), get()) }
}
