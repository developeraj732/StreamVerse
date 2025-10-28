package com.example.streamverse.di

import com.example.streamverse.data.mapper.WatchMapper
import com.example.streamverse.data.repository.WatchRepository
import com.example.streamverse.data.repository.WatchRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {
    single { WatchMapper() }
    single <WatchRepository> { WatchRepositoryImpl(get(), get()) }
}