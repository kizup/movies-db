package com.example.moviesdb.network.model

import java.util.*

data class Movie(
    val posterPath: String?,
    val adult: Boolean,
    val overview: String?,
    val releaseDate: Date?,
    val genreIds: List<Int>,
    val id: Long,
    val originalTitle: String,
    val originalLanguage: String,
    val title: String,
    val backdropPath: String?,
    val popularity: Float,
    val voteCount: Long,
    val haveVideo: Boolean,
    val voteAverage: Float
)