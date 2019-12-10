package com.example.moviesdb.network.impl

import com.example.moviesdb.network.api.TheMovieDBClientApi
import com.example.moviesdb.network.model.Movie
import info.movito.themoviedbapi.TmdbApi
import info.movito.themoviedbapi.model.MovieDb
import io.reactivex.Single
import java.text.SimpleDateFormat
import java.util.*

class TMDBLibClientApiImpl(
    private val tmdbApi: TmdbApi
) : TheMovieDBClientApi {

    private companion object {
        private val RELEASE_DATE_PARSER = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
    }

    override fun loadNowPlayingMovies(page: Int): Single<List<Movie>> {
        throw NotImplementedError()
    }

    override fun loadPopularMovies(page: Int): Single<List<Movie>> {
        throw NotImplementedError()
    }

    fun MovieDb.toMovie(): Movie {
        this.apply {
            return Movie(
                posterPath,
                isAdult,
                overview,
                RELEASE_DATE_PARSER.parse(releaseDate),
                genres.map { genre -> genre.id },
                id.toLong(),
                originalTitle,
                originalLanguage,
                title,
                backdropPath,
                popularity,
                voteCount.toLong(),
                false,
                voteAverage
            )
        }
    }

}