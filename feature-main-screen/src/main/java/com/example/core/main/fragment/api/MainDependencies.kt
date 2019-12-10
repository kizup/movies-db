package com.example.core.main.fragment.api

import com.example.moviesdb.network.api.TheMovieDBClientApi
import com.example.moviesdb.utils.ComponentDependencies

interface MainDependencies : ComponentDependencies {

    fun theMovidDbClient() : TheMovieDBClientApi

}