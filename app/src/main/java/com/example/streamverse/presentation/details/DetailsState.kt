package com.example.streamverse.presentation.details

import com.example.streamverse.data.model.response.WatchContent

sealed class DetailsState{

    data object  Loading : DetailsState()
    data class Success(val content : WatchContent) : DetailsState()
    data class Error (val message: String) : DetailsState()
}