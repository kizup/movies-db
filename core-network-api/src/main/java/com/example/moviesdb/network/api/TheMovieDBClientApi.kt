package com.example.moviesdb.network.api

import com.example.moviesdb.network.model.Movie
import com.example.moviesdb.network.model.MovieType
import com.example.moviesdb.network.model.TvShow
import com.example.moviesdb.network.model.TvShowType
import io.reactivex.Single

interface TheMovieDBClientApi {

    /**
     * Method for loading movies list
     * @param type - movie type for loading
     * @param page - page, minimum 1, maximum 1000,
     */
    fun loadMovies(
        type: MovieType,
        page: Int = 1
    ): Single<List<Movie>>

    /**
     * Method for loading tv shows list
     * @param type - tv show type for loading
     * @param page - page, minimum 1, maximum 1000,
     */
    fun loadTvShows(
        type: TvShowType,
        page: Int = 1
    ): Single<List<TvShow>>

}