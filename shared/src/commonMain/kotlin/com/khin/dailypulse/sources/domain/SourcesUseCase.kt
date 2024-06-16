package com.khin.dailypulse.sources.domain

import com.khin.dailypulse.sources.data.SourcesRaw
import com.khin.dailypulse.sources.data.SourcesRepository

class SourcesUseCase(private val sourcesRepository: SourcesRepository) {

    suspend fun getSources(forceRefresh: Boolean): List<Source> {
        return mapSources(sourcesRepository.getSources(forceRefresh))
    }

    private fun mapSources(sources: List<SourcesRaw>): List<Source> = sources.map {
        Source(
            id = it.id,
            name = it.name,
            description = it.description,
            langAndCountry = "${it.language} - ${it.country}"
        )
    }
}