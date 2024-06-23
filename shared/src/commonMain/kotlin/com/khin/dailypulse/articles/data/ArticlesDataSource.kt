package com.khin.dailypulse.articles.data

import com.khin.dailypulse.db.DailyPulseDatabase

class ArticlesDataSource(private val database: DailyPulseDatabase?) {

    fun getAllArticles() =
        database?.dailyPulseDatabaseQueries?.selectAllArticles(::mapToArticleRaw)?.executeAsList() ?: emptyList()

    fun insertArticles(articles: List<ArticleRaw>) {
        database?.dailyPulseDatabaseQueries?.transaction {
            articles.forEach { articleRaw ->
                insertArticle(articleRaw)
            }
        }
    }

    fun clearArticles() {
        database?.dailyPulseDatabaseQueries?.removeAllArticles()
    }

    private fun insertArticle(articleRaw: ArticleRaw) {
        database?.dailyPulseDatabaseQueries?.insertArticle(
            title = articleRaw.title,
            description = articleRaw.description,
            date = articleRaw.date,
            imageUrl = articleRaw.imageUrl
        )
    }

    private fun mapToArticleRaw(
        title: String,
        description: String?,
        date: String,
        imageUrl: String?
    ): ArticleRaw {
        return ArticleRaw(
            title = title,
            description = description,
            date = date,
            imageUrl = imageUrl
        )
    }
}