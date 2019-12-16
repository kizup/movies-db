package com.example.feature.home.screen.api

import com.example.moviesdb.network.api.TheMovieDBClientApi
import com.example.moviesdb.root.tab.navigation.ILocalNavigator
import com.example.moviesdb.utils.ComponentDependencies

interface HomeDependencies : ComponentDependencies {

    fun tmdbClient(): TheMovieDBClientApi

}

interface HomeNavigatorDependencies : ComponentDependencies {

    fun localNavigator(): ILocalNavigator

}