package com.example.moviesdb.network.model

import java.util.*

data class TvShow(
    val posterPath: String?,
    val overview: String?,
    val releaseDate: Date?,
    val genreIds: List<Int>,
    val id: Long,
    val originalLanguage: String,
    val backdropPath: String?,
    val popularity: Float,
    val voteCount: Long,
    val voteAverage: Float
)