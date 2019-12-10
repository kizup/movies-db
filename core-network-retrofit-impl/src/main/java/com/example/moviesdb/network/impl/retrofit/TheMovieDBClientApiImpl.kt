package com.example.moviesdb.network.impl.retrofit

import com.example.moviesdb.network.api.TheMovieDBClientApi
import com.example.moviesdb.network.model.Movie
import io.reactivex.Single

class TheMovieDBClientApiImpl(
    private val apiService: IApiService
) : TheMovieDBClientApi {

    override fun loadPopularMovies(page: Int): Single<List<Movie>> {
        return apiService.loadPopularMovies(page)
            .map { response ->
                if (response.results == null) {
                    return@map emptyList<Movie>()
                } else {
                    return@map response.results
                        .map { it.toMovie() }
                }
            }
    }

    override fun loadNowPlayingMovies(page: Int): Single<List<Movie>> {
        return apiService.loadNowPlayingMovies(page)
            .map { response ->
                if (response.results == null) {
                    return@map emptyList<Movie>()
                } else {
                    return@map response.results
                        .map { it.toMovie() }
                }
            }
    }
}