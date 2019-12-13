package com.example.moviesdb.di

import com.example.moviesdb.network.api.TheMovieDBClientApi
import com.example.moviesdb.network.impl.TMDBLibClientApiImpl
import com.example.moviesdb.network.impl.retrofit.RetrofitClientApiImpl
import com.example.moviesdb.network.model.RETROFIT_IMPL
import com.example.moviesdb.network.model.TMDBLIB_IMPL
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class ProxyNetworkProvider(
    private val retrofitClientApi: RetrofitClientApiImpl,
    private val tmdbLibClientApi: TMDBLibClientApiImpl
) {

    @Provides
    @Named(RETROFIT_IMPL)
    fun provideRetrofitClient(): TheMovieDBClientApi {
        return retrofitClientApi
    }

    @Provides
    @Named(TMDBLIB_IMPL)
    fun provideTmdbClient(): TheMovieDBClientApi {
        return tmdbLibClientApi
    }

}