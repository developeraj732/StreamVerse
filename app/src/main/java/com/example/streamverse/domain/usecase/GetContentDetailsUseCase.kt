package com.example.streamverse.domain.usecase

import com.example.streamverse.data.model.response.WatchContent
import com.example.streamverse.data.repository.WatchRepository

class GetContentDetailsUseCase(private val repository: WatchRepository) {

    suspend operator fun invoke(contentId: String, isMovie: Boolean): WatchContent {
        return repository.getContentDetails(contentId, isMovie)
    }
}