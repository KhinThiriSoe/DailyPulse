package com.khin.dailypulse.sources.di

import com.khin.dailypulse.sources.data.SourcesDataSource
import com.khin.dailypulse.sources.data.SourcesRepository
import com.khin.dailypulse.sources.data.SourcesService
import com.khin.dailypulse.sources.domain.SourcesUseCase
import com.khin.dailypulse.sources.presentation.SourcesViewModel
import org.koin.dsl.module

val sourcesModule = module {

    single<SourcesService> { SourcesService(get()) }
    single<SourcesUseCase> { SourcesUseCase(get()) }
    single<SourcesViewModel> { SourcesViewModel(get()) }
    single<SourcesDataSource> { SourcesDataSource(getOrNull()) }
    single<SourcesRepository> { SourcesRepository(get(), get()) }
}