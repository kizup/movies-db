package com.example.moviesdb.movies.list.api

import com.example.moviesdb.movies.list.adapter.MovieItem

interface MoviesListNavigator {

    fun navigateToMovieDetails(movie: MovieItem)

}