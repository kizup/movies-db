package com.example.moviesdb.network.impl.retrofit

import com.example.moviesdb.network.api.TheMovieDBClientApi
import com.example.moviesdb.network.model.Movie
import com.example.moviesdb.network.model.RETROFIT_IMPL
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Named
import javax.inject.Singleton

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

}