package com.example.moviesdb.movies.list.di

import com.example.moviesdb.movies.list.api.MoviesListNavigator
import ru.terrakok.cicerone.Router

class GlobalNavigator(
    private val router: Router
) : MoviesListNavigator {

}