package com.example.moviesdb.network.impl

import com.example.moviesdb.network.api.TheMovieDBClientApi
import com.example.moviesdb.network.model.Movie
import info.movito.themoviedbapi.TmdbApi
import io.reactivex.Single
import java.text.SimpleDateFormat
import java.util.*

class TMDBLibClientApiImpl(
    private val tmdbApi: TmdbApi
) : TheMovieDBClientApi {

    private companion object {
        private val RELEASE_DATE_PARSER = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
    }

    override fun loadPopularMovies(page: Int): Single<List<Movie>> {
        return Single.fromCallable {
            tmdbApi.movies.getPopularMovies("ru", page)
                .results
                .map { movieDb ->
                    Movie(
                        movieDb.posterPath,
                        movieDb.isAdult,
                        movieDb.overview,
                        RELEASE_DATE_PARSER.parse(movieDb.releaseDate),
                        movieDb.genres.map { genre -> genre.id },
                        movieDb.id.toLong(),
                        movieDb.originalTitle,
                        movieDb.originalLanguage,
                        movieDb.title,
                        movieDb.backdropPath,
                        movieDb.popularity,
                        movieDb.voteCount.toLong(),
                        false,
                        movieDb.voteAverage
                    )
                }
        }
    }

}