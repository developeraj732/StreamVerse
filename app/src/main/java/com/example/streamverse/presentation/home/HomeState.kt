package com.example.streamverse.presentation.home

import com.example.streamverse.data.model.response.WatchContent

sealed class HomeState {
    object Loading : HomeState()
    data class Success(
        val movies: List<WatchContent>,
        val tvShows: List<WatchContent>
    ) : HomeState()
    data class Error(val message: String) : HomeState()
}