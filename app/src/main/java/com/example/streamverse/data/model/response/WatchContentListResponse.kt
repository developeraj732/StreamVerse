package com.example.streamverse.data.model.response

data class WatchContentListResponse(
    val results: List<WatchContentResponse>,
    val totalPages: Int,
    val totalResult: Int
)