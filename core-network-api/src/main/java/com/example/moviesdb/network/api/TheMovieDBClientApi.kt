package com.example.moviesdb.network.api

import com.example.moviesdb.network.model.Movie
import com.example.moviesdb.network.model.TvShow
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


    /**
     * https://developers.themoviedb.org/3/movies/get-top-rated-movies
     *
     * Get the top rated movies on TMDb.
     * @param page - page, minimum 1, maximum 1000,
     */
    fun loadTopRatedMovies(
        page: Int = 1
    ): Single<List<Movie>>


    /**
     * https://developers.themoviedb.org/3/movies/get-upcoming
     *
     * Get a list of upcoming movies in theatres.
     * @param page - page, minimum 1, maximum 1000,
     */
    fun loadUpcomingMovies(
        page: Int = 1
    ): Single<List<Movie>>


    /**
     * https://developers.themoviedb.org/3/tv/get-top-rated-tv
     *
     * Get a list of the top rated TV shows on TMDb.
     * @param page - page, minimum 1, maximum 1000,
     */
    fun loadTvTopRatedSerials(
        page: Int = 1
    ): Single<List<TvShow>>


    /**
     * https://developers.themoviedb.org/3/tv/get-popular-tv
     *
     * Get a list of the top rated TV shows on TMDb.
     * @param page - page, minimum 1, maximum 1000,
     */
    fun loadTvPopularSerials(
        page: Int = 1
    ): Single<List<TvShow>>

}