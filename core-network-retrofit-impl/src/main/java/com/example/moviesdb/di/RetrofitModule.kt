package com.example.moviesdb.di

import com.example.moviesdb.network.api.TheMovieDBClientApi
import com.example.moviesdb.network.impl.retrofit.TheMovieDBClientApiImpl
import dagger.Binds
import dagger.Module

@Module
interface RetrofitModule {

    @Binds
    fun theMovieDbClient(client: TheMovieDBClientApiImpl): TheMovieDBClientApi
}