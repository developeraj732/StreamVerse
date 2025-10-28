package com.example.streamverse.di

import com.example.streamverse.data.api.WatchModeApi
import com.facebook.shimmer.BuildConfig
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val networkModule = module {
    single {
        provideAuthInterceptor()
    }

    single {
        provideOkHttpClient(get())
    }

    single {
        Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/3/")
            .client(get())
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .build()
    }

    single {
        get<Retrofit>().create(WatchModeApi::class.java)
    }
}

private fun provideAuthInterceptor() = Interceptor { chain ->
    val request = chain.request()
    val newUrl = request.url.newBuilder()
        .addQueryParameter("api_key", "213df1c6aa314e857e9ae219df2f3e6d")
        .build()
    val newRequest = request.newBuilder()
        .url(newUrl)
        .build()
    chain.proceed(newRequest)
}

private fun provideOkHttpClient(authInterceptor: Interceptor) = OkHttpClient.Builder()
    .addInterceptor(authInterceptor)
    .addInterceptor(HttpLoggingInterceptor().apply {
        level = if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor.Level.BODY
        } else {
            HttpLoggingInterceptor.Level.NONE
        }
    })
    .connectTimeout(15, TimeUnit.SECONDS)
    .readTimeout(15, TimeUnit.SECONDS)
    .writeTimeout(15, TimeUnit.SECONDS)
    .build()