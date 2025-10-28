package com.example.streamverse.di

import com.example.streamverse.WatchApplication
import com.example.streamverse.domain.usecase.GetContentDetailsUseCase
import com.example.streamverse.domain.usecase.GetMoviesAndTvShowsUseCase
import com.example.streamverse.presentation.details.DetailsViewModel
import com.example.streamverse.presentation.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single { WatchApplication() }

    factory { GetContentDetailsUseCase(get()) }
    factory { GetMoviesAndTvShowsUseCase(get()) }

    viewModel { HomeViewModel(get()) }
    viewModel { DetailsViewModel(get()) }
}