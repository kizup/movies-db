package com.example.moviesdb.network.impl.retrofit

import com.example.moviesdb.network.api.TheMovieDBClientApi
import com.example.moviesdb.network.impl.responses.PagingResponse
import com.example.moviesdb.network.impl.responses.movie.MovieResponse
import com.example.moviesdb.network.impl.responses.movie.TvShowResponse
import com.example.moviesdb.network.model.Movie
import com.example.moviesdb.network.model.MovieType
import com.example.moviesdb.network.model.TvShow
import com.example.moviesdb.network.model.TvShowType
import io.reactivex.Single

class TheMovieDBClientApiImpl(
    private val apiService: IApiService
) : TheMovieDBClientApi {

    override fun loadMovies(
        type: MovieType,
        page: Int
    ): Single<List<Movie>> {
        return when (type) {
            is MovieType.Popular -> loadPopularMovies(page)
            is MovieType.NowPlaying -> loadNowPlayingMovies(page)
            is MovieType.TopRated -> loadTopRatedMovies(page)
            is MovieType.Upcoming -> loadUpcomingMovies(page)
        }
    }

    override fun loadTvShows(
        type: TvShowType,
        page: Int
    ): Single<List<TvShow>> {
        return when (type) {
            is TvShowType.Popular -> loadTvPopularSerials(page)
            is TvShowType.TopRated -> loadTvTopRatedSerials(page)
        }
    }

    private fun loadPopularMovies(page: Int): Single<List<Movie>> {
        return apiService.loadPopularMovies(page).toMoviesList()
    }

    private fun loadNowPlayingMovies(page: Int): Single<List<Movie>> {
        return apiService.loadNowPlayingMovies(page).toMoviesList()
    }

    private fun loadTopRatedMovies(page: Int): Single<List<Movie>> {
        return apiService.loadTopRatedMovies(page).toMoviesList()
    }

    private fun loadUpcomingMovies(page: Int): Single<List<Movie>> {
        return apiService.loadUpcomingMovies(page).toMoviesList()
    }

    private fun loadTvTopRatedSerials(page: Int): Single<List<TvShow>> {
        return apiService.loadTopRatedTv(page).toTvShowsList()
    }

    private fun loadTvPopularSerials(page: Int): Single<List<TvShow>> {
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