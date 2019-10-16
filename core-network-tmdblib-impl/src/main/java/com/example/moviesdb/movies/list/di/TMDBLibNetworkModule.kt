package com.example.moviesdb.movies.list.di

import com.example.moviesdb.network.api.TheMovieDBClientApi
import com.example.moviesdb.network.impl.TMDBLibClientApiImpl
import com.example.moviesdb.network.model.API_KEY
import dagger.Module
import dagger.Provides
import info.movito.themoviedbapi.TmdbApi
import javax.inject.Named
import javax.inject.Singleton

@Module
class TMDBLibNetworkModule {

    @Provides
    @Singleton
    @Named("1")
    fun provideTheMovieDbLibraryApiClient(tmdbApi: TmdbApi): TheMovieDBClientApi {
        return TMDBLibClientApiImpl(tmdbApi)
    }

    @Provides
    @Singleton
    fun provideTmddbApi(): TmdbApi {
        return TmdbApi(API_KEY)
    }

}