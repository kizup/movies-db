package com.example.moviesdb.network.model

sealed class MovieType {
    object Popular : MovieType()
    object NowPlaying : MovieType()
    object TopRated : MovieType()
    object Upcoming : MovieType()
}

sealed class TvShowType {
    object Popular : TvShowType()
    object TopRated : TvShowType()
}