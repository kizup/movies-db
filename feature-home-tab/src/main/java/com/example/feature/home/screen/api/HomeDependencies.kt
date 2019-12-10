package com.example.feature.home.screen.api

import com.example.moviesdb.network.api.TheMovieDBClientApi
import com.example.moviesdb.utils.ComponentDependencies

interface HomeDependencies : ComponentDependencies {

    fun tmdbClient(): TheMovieDBClientApi

}