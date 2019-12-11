package com.example.moviesdb.network.impl.responses.movie

import com.example.moviesdb.network.model.TvShow
import com.google.gson.annotations.SerializedName
import java.util.*

data class TvShowResponse(
    @SerializedName("original_name") val originalName: String,
    @SerializedName("id") val id: Long,
    @SerializedName("name") val name: String,
    @SerializedName("popularity") val popularity: Float,
    @SerializedName("vote_count") val voteCount: Long,
    @SerializedName("vote_average") val voteAverage: Float,
    @SerializedName("first_air_date") val firstAirDate: Date?,
    @SerializedName("poster_path") val posterPath: String?,
    @SerializedName("genre_ids") val genres: List<Int>,
    @SerializedName("original_language") val originalLanguage: String,
    @SerializedName("backdrop_path") val backdropPath: String?,
    @SerializedName("overview") val overview: String,
    @SerializedName("origin_country") val originCountry: List<String>
) {

    fun toTvShow(): TvShow {
        return TvShow(
            posterPath,
            overview,
            firstAirDate,
            genres,
            id,
            originalLanguage,
            backdropPath,
            popularity,
            voteCount,
            voteAverage
        )
    }

}

/*
{
      "original_name": "I Am Not an Animal",
      "id": 100,
      "name": "Я Не Животное",
      "popularity": 10.17,
      "vote_count": 371,
      "vote_average": 9.5,
      "first_air_date": "2004-05-10",
      "poster_path": "/nMhv6jG5dtLdW7rgguYWvpbk0YN.jpg",
      "genre_ids": [
        16,
        35
      ],
      "original_language": "en",
      "backdrop_path": "/ok1YiumqOCYzUmuTktnupOQOvV5.jpg",
      "overview": "«Я не животное» - анимационный комедийный сериал о единственных шести говорящих животных в мире, чье существование в вивисекционном отделении перевернулось с ног на голову, когда они были освобождены активистами по защите прав животных.",
      "origin_country": [
        "GB"
      ]
    }
 */