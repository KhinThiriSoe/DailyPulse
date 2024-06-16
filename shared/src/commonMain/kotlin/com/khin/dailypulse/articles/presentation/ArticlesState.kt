package com.khin.dailypulse.articles.presentation

import com.khin.dailypulse.articles.domain.Article

data class ArticlesState(
    val articles: List<Article> = listOf(),
    val loading: Boolean = false,
    val error: String? = null
)