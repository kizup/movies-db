package com.example.moviesdb.movies.list.di

import com.example.core.main.fragment.api.MainNavigator
import com.example.moviesdb.movies.list.adapter.MovieItem
import com.example.moviesdb.movies.list.api.MoviesListNavigator
import ru.terrakok.cicerone.Router

class GlobalNavigator(
    private val router: Router
) : MoviesListNavigator {

    override fun navigateToMovieDetails(movie: MovieItem) {
        println("Navigate to details screen!")
    }

}