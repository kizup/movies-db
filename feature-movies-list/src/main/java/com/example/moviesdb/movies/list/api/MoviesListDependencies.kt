package com.example.moviesdb.movies.list.api

import com.example.moviesdb.network.api.TheMovieDBClientApi
import com.example.moviesdb.utils.ComponentDependencies

interface MoviesListDependencies : ComponentDependencies {

    fun theMovieDbClient(): TheMovieDBClientApi

}