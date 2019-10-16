package com.example.moviesdb.movies.list.di

import com.example.moviesdb.network.api.TheMovieDBClientApi
import com.example.moviesdb.utils.ComponentDependencies

interface CoreNetworkApiDependencies : ComponentDependencies {

    fun theMovieDbClient(): TheMovieDBClientApi

}