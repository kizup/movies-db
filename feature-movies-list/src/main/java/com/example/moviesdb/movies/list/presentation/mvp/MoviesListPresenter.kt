package com.example.moviesdb.movies.list.presentation.mvp

import com.example.moviesdb.movies.list.presentation.view.IMoviesListView
import com.example.moviesdb.network.api.TheMovieDBClientApi
import com.example.moviesdb.presentation.mvp.base.BasePresenter
import io.reactivex.schedulers.Schedulers
import moxy.InjectViewState
import javax.inject.Inject

@InjectViewState
class MoviesListPresenter @Inject constructor(
    private val tmdbClient: TheMovieDBClientApi
) : BasePresenter<IMoviesListView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        loadMoviesList()
    }

    private fun loadMoviesList() {
        launch { tmdbClient.loadPopularMovies()
            .subscribeOn(Schedulers.io())
            .subscribe({
                println()
            }, {
                println()
            })
        }
    }

}