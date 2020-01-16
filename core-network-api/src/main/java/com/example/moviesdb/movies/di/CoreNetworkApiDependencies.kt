package com.example.moviesdb.movies.di

import com.example.moviesdb.network.api.TheMovieDBClientApi
import com.example.moviesdb.utils.ComponentDependencies

interface CoreNetworkApiDependencies : ComponentDependencies {

    fun theMovieDbClient(): TheMovieDBClientApi

}