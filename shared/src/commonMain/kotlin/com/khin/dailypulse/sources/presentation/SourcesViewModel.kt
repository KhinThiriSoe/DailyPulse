package com.khin.dailypulse.sources.presentation

import com.khin.dailypulse.BaseViewModel
import com.khin.dailypulse.sources.domain.SourcesUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class SourcesViewModel(private val useCase: SourcesUseCase) : BaseViewModel() {

    private val _sourcesState = MutableStateFlow(SourcesState(loading = true))
    val sourcesState: StateFlow<SourcesState> = _sourcesState

    private fun updateState(state: SourcesState) {
        _sourcesState.value = state
    }

    init {
        getSources()
    }

    fun getSources(forceRefresh: Boolean = false) {
        scope.launch {
            _sourcesState.emit(SourcesState(loading = true, sources = _sourcesState.value.sources))
            val fetchedSources = useCase.getSources(forceRefresh)
            _sourcesState.emit(SourcesState(sources = fetchedSources))
        }
    }
}