package com.example.moviesdb.network.impl.responses.movie

import com.example.moviesdb.network.model.Movie
import com.google.gson.annotations.SerializedName
import java.util.*

data class MovieResponse(
    @SerializedName("poster_path") val posterPath: String?,
    @SerializedName("adult") val adult: Boolean,
    @SerializedName("overview") val overview: String?,
    @SerializedName("release_date") val releaseDate: Date?,
    @SerializedName("genre_ids") val genreIds: List<Int>,
    @SerializedName("id") val id: Long,
    @SerializedName("original_title") val originalTitle: String,
    @SerializedName("original_language") val originalLanguage: String,
    @SerializedName("title") val title: String,
    @SerializedName("backdrop_path") val backdropPath: String?,
    @SerializedName("popularity") val popularity: Float,
    @SerializedName("video") val haveVideo: Boolean,
    @SerializedName("vote_count") val voteCount: Long,
    @SerializedName("vote_average") val voteAverage: Float
) {


    fun toMovie(): Movie = Movie(
        posterPath,
        adult,
        overview,
        releaseDate,
        genreIds,
        id,
        originalTitle,
        originalLanguage,
        title,
        backdropPath,
        popularity,
        voteCount,
        haveVideo,
        voteAverage
    )

}