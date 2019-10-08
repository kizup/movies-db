package com.example.moviesdb.network.impl.retrofit

import com.example.moviesdb.network.api.TheMovieDBClientApi
import com.example.moviesdb.network.model.Movie
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

class TheMovieDBClientApiImpl(
    private val apiService: IApiService
) : TheMovieDBClientApi {

    override fun loadPopularMovies(page: Int): Single<List<Movie>> {
        return apiService.loadPopularMovies(page)
    }

}