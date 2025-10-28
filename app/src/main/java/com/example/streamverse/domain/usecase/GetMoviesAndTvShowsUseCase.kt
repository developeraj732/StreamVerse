package com.example.streamverse.domain.usecase

import com.example.streamverse.data.model.response.WatchContent
import com.example.streamverse.data.repository.WatchRepository
import io.reactivex.rxjava3.core.Single

class GetMoviesAndTvShowsUseCase(private val repository: WatchRepository) {

    operator fun invoke(): Single<Pair<List<WatchContent>, List<WatchContent>>> {
        return repository.getMoviesAndTvShows()
    }

}