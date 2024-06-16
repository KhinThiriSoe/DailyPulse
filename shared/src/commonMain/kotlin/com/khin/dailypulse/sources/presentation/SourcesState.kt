package com.khin.dailypulse.sources.presentation

import com.khin.dailypulse.sources.domain.Source

data class SourcesState(
    val sources: List<Source> = listOf(),
    val loading: Boolean = false,
    val error: String? = null
)