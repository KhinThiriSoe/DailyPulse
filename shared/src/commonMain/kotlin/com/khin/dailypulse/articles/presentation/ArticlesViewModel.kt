package com.khin.dailypulse.articles.presentation

import com.khin.dailypulse.BaseViewModel
import com.khin.dailypulse.articles.domain.ArticlesUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ArticlesViewModel(
    private val useCase: ArticlesUseCase
): BaseViewModel() {

    private val _articlesState : MutableStateFlow<ArticlesState> = MutableStateFlow(ArticlesState(loading = true))

    val articlesState: StateFlow<ArticlesState>
        get() = _articlesState

    private fun updateState(state: ArticlesState) {
        _articlesState.value = state
    }

    init {
        getArticles()
    }

    fun getArticles(forceRefresh: Boolean = false) {
        scope.launch {
            _articlesState.emit(ArticlesState(loading = true, articles = _articlesState.value.articles))
            val fetchedArticles = useCase.getArticles(forceRefresh)
            _articlesState.emit(ArticlesState(articles = fetchedArticles))
        }
    }
}