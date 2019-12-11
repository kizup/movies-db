package com.example.moviesdb.network.impl.retrofit

import com.example.moviesdb.network.impl.responses.PagingResponse
import com.example.moviesdb.network.impl.responses.movie.MovieResponse
import com.example.moviesdb.network.impl.responses.movie.TvShowResponse
import com.example.moviesdb.network.model.Movie
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface IApiService {

    @GET("movie/popular")
    fun loadPopularMovies(
        @Query("page") page: Int
    ): Single<PagingResponse<MovieResponse>>

    @GET("movie/now_playing")
    fun loadNowPlayingMovies(
        @Query("page") page: Int
    ): Single<PagingResponse<MovieResponse>>

    @GET("movie/top_rated")
    fun loadTopRatedMovies(
        @Query("page") page: Int
    ): Single<PagingResponse<MovieResponse>>

    @GET("movie/upcoming")
    fun loadUpcomingMovies(
        @Query("page") page: Int
    ): Single<PagingResponse<MovieResponse>>

    @GET("tv/top_rated")
    fun loadTopRatedTv(
        @Query("page") page: Int
    ): Single<PagingResponse<TvShowResponse>>

    @GET("tv/popular")
    fun loadPopularTv(
        @Query("page") page: Int
    ): Single<PagingResponse<TvShowResponse>>

}