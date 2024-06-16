package com.khin.dailypulse.sources.data

class SourcesRepository(
    private val sourcesDataSource: SourcesDataSource,
    private val sourcesService: SourcesService
) {

    suspend fun getSources(forceRefresh: Boolean = false): List<SourcesRaw> {
        if (forceRefresh) {
            sourcesDataSource.clearSources()
            return fetchSources()
        }
        val sourcesDb = sourcesDataSource.getAllSources()
        return sourcesDb.ifEmpty {
            fetchSources()
        }
    }

    private suspend fun fetchSources(): List<SourcesRaw> {
        val fetchedSources = sourcesService.fetchSources()
        sourcesDataSource.insertSources(fetchedSources)
        return fetchedSources
    }

    fun getAllSources() = sourcesDataSource.getAllSources()
}