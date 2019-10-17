package com.example.moviesdb.movies.list.presentation.view

import com.example.moviesdb.movies.list.adapter.MovieItem
import com.example.moviesdb.presentation.view.base.IBaseView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

interface IMoviesListView : IBaseView {

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun addMovies(movies: List<MovieItem>)

}