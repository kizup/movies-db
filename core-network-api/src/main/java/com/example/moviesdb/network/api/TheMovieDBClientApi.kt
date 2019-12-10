package com.example.moviesdb.network.api

import com.example.moviesdb.network.model.Movie
import io.reactivex.Single

interface TheMovieDBClientApi {

    /**
     * https://developers.themoviedb.org/3/movies/get-popular-movies
     *
     * Load popular movies list
     * @param page - page, minimum 1, maximum 1000,
     */
    fun loadPopularMovies(
        page: Int = 1
    ): Single<List<Movie>>


    /**
     * https://developers.themoviedb.org/3/movies/get-now-playing
     *
     * Get a list of movies in theatres
     * @param page - page, minimum 1, maximum 1000,
     */
    fun loadNowPlayingMovies(
        page: Int = 1
    ): Single<List<Movie>>

}