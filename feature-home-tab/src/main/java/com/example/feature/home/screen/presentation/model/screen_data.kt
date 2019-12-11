package com.example.feature.home.screen.presentation.model

data class AllMovies(
    val popular: List<MovieItem>,
    val nowPlaying: List<MovieItem>,
    val topRated: List<MovieItem>,
    val upcoming: List<MovieItem>
)

data class AllTvShows(
    val tvTopRated: List<TvShowItem>,
    val tvPopular: List<TvShowItem>
)

data class HomeTabScreenData(
    val allMovies: AllMovies,
    val tvShows: AllTvShows
)