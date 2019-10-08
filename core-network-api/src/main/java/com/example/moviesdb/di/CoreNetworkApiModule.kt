package com.example.moviesdb.di

import com.example.moviesdb.network.api.TheMovieDBClientApi
import dagger.Module
import dagger.Provides

@Module
class CoreNetworkApiModule(
    private val client: TheMovieDBClientApi
) {

    @Provides
    fun provideTheMovieDbClientApi(): TheMovieDBClientApi = client

}