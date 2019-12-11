package com.example.moviesdb.network.impl.retrofit

import com.example.moviesdb.network.api.TheMovieDBClientApi
import com.example.moviesdb.network.impl.responses.PagingResponse
import com.example.moviesdb.network.impl.responses.movie.MovieResponse
import com.example.moviesdb.network.impl.responses.movie.TvShowResponse
import com.example.moviesdb.network.model.Movie
import com.example.moviesdb.network.model.TvShow
import io.reactivex.Single

class TheMovieDBClientApiImpl(
    private val apiService: IApiService
) : TheMovieDBClientApi {

    override fun loadPopularMovies(page: Int): Single<List<Movie>> {
        return apiService.loadPopularMovies(page).toMoviesList()
    }

    override fun loadNowPlayingMovies(page: Int): Single<List<Movie>> {
        return apiService.loadNowPlayingMovies(page).toMoviesList()
    }

    override fun loadTopRatedMovies(page: Int): Single<List<Movie>> {
        return apiService.loadTopRatedMovies(page).toMoviesList()
    }

    override fun loadUpcomingMovies(page: Int): Single<List<Movie>> {
        return apiService.loadUpcomingMovies(page).toMoviesList()
    }

    override fun loadTvTopRatedSerials(page: Int): Single<List<TvShow>> {
        return apiService.loadTopRatedTv(page).toTvShowsList()
    }

    override fun loadTvPopularSerials(page: Int): Single<List<TvShow>> {
        return apiService.loadPopularTv(page).toTvShowsList()
    }

    private fun Single<PagingResponse<MovieResponse>>.toMoviesList(): Single<List<Movie>> {
        return this.map { response ->
            if (response.results == null) {
                return@map emptyList<Movie>()
            } else {
                return@map response.results
                    .map { it.toMovie() }
            }
        }
    }

    private fun Single<PagingResponse<TvShowResponse>>.toTvShowsList(): Single<List<TvShow>> {
        return this.map { response ->
            if (response.results == null) {
                return@map emptyList<TvShow>()
            } else {
                return@map response.results
                    .map { it.toTvShow() }
            }
        }
    }

}