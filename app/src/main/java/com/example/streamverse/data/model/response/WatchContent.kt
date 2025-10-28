package com.example.streamverse.data.model.response

data class WatchContent(
    val id: String,
    val title: String,
    val posterUrl: String,
    val description: String,
    val releaseDate: String,
    val type: String,
    val isMovie: Boolean
)