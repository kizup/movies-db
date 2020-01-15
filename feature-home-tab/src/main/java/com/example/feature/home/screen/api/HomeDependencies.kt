package com.example.feature.home.screen.api

import com.example.moviesdb.network.api.TheMovieDBClientApi
import com.example.moviesdb.utils.ComponentDependencies

/**
 * This interface contains dependencies for home tab screen
 * Dependencies provides by AppComponent
 */
interface HomeDependencies : ComponentDependencies {

    fun tmdbClient(): TheMovieDBClientApi

}