package com.khin.dailypulse.sources.domain

data class Source(
    val id: String,
    val name: String,
    val description: String,
    val langAndCountry: String
)