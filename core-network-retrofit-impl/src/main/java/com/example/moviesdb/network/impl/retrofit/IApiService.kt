package com.example.moviesdb.network.impl.retrofit

import com.example.moviesdb.network.impl.responses.PagingResponse
import com.example.moviesdb.network.impl.responses.movie.MovieResponse
import com.example.moviesdb.network.model.Movie
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface IApiService {

    @GET("movie/popular")
    fun loadPopularMovies(
        @Query("page") page: Int
    ): Single<PagingResponse<MovieResponse>>

    @GET("/movie/now_playing")
    fun loadNowPlayingMovies(
        @Query("page") page: Int
    ): Single<PagingResponse<MovieResponse>>

}