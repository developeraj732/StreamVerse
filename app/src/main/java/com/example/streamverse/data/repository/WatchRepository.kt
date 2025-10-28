package com.example.streamverse.data.repository

import com.example.streamverse.data.model.response.WatchContent
import io.reactivex.rxjava3.core.Single

interface WatchRepository {
    fun getMoviesAndTvShows(): Single<Pair<List<WatchContent>, List<WatchContent>>>

    suspend fun getContentDetails(
        contentId: String,
        isMovie: Boolean,
    ): WatchContent
}
