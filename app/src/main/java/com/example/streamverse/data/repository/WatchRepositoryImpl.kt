package com.example.streamverse.data.repository

import com.example.streamverse.data.api.WatchModeApi
import com.example.streamverse.data.mapper.WatchMapper
import com.example.streamverse.data.model.response.WatchContent
import io.reactivex.rxjava3.core.Single

class WatchRepositoryImpl(
    private val api: WatchModeApi,
    private val mapper: WatchMapper
) : WatchRepository {
    override fun getMoviesAndTvShows(): Single<Pair<List<WatchContent>, List<WatchContent>>> {
        return Single.zip(
            api.getMovies()
                .map { mapper.mapResponseListToWatchContent(it.results) },
            api.getTvShows()
                .map { mapper.mapResponseListToWatchContent(it.results) }
        ) { movies, tvShows ->
            Pair(movies, tvShows)

        }
    }

    override suspend fun getContentDetails(contentId: String, isMovie: Boolean): WatchContent {
        return if (isMovie) {
            mapper.mapResponseToWatchContent(api.getMovieDetails(contentId.toInt()))
        } else {
            mapper.mapResponseToWatchContent(api.getTvShowDetails(contentId.toInt()))
        }
    }


}