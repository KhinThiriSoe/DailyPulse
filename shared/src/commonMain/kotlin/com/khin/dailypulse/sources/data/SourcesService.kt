package com.khin.dailypulse.sources.data

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class SourcesService(private val httpClient: HttpClient) {

    private val category = "business"
    private val apiKey = "648447b7bc55479bb86cc70e0a1a56d1"

    suspend fun fetchSources(): List<SourcesRaw> {
        val response: SourcesResponse = httpClient
            .get("https://newsapi.org/v2/top-headlines/sources?category=$category&apiKey=$apiKey").body()
        return response.sources
    }
}