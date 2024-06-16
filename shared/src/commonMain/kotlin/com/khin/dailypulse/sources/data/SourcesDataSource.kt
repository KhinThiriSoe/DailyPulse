package com.khin.dailypulse.sources.data

import com.khin.dailypulse.db.DailyPulseDatabase

class SourcesDataSource(private val database: DailyPulseDatabase) {

    fun getAllSources() =
        database.dailyPulseDatabaseQueries.selectAllSources(::mapToSourcesRaw).executeAsList()

    fun insertSources(sources: List<SourcesRaw>) {
        database.dailyPulseDatabaseQueries.transaction {
            sources.forEach { sourcesRaw ->
                insertSources(sourcesRaw)
            }
        }
    }

    fun clearSources() {
        database.dailyPulseDatabaseQueries.removeAllSources()
    }

    private fun insertSources(sourcesRaw: SourcesRaw) {
        database.dailyPulseDatabaseQueries.insertSource(
            id = sourcesRaw.id,
            name = sourcesRaw.name,
            description = sourcesRaw.description,
            language = sourcesRaw.language,
            country = sourcesRaw.country
        )
    }

    private fun mapToSourcesRaw(
        id: String,
        name: String,
        description: String,
        language: String,
        country: String
    ): SourcesRaw {
        return SourcesRaw(
            id = id,
            name = name,
            description = description,
            language = language,
            country = country
        )
    }
}
