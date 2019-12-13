package com.example.moviesdb.movies.list.presentation.mvp

import com.example.moviesdb.movies.list.api.MoviesListNavigator
import com.example.moviesdb.movies.list.presentation.view.IMoviesListView
import com.example.moviesdb.network.api.TheMovieDBClientApi
import com.example.moviesdb.presentation.mvp.base.BasePresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import moxy.InjectViewState
import javax.inject.Inject

@InjectViewState
class MoviesListPresenter @Inject constructor(
    private val tmdbClient: TheMovieDBClientApi,
    private val navigator: MoviesListNavigator
) : BasePresenter<IMoviesListView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        loadMoviesList()
    }

    private fun loadMoviesList() {
//        launch { tmdbClient.loadPopularMovies()
//            .subscribeOn(Schedulers.io())
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribe({ movies ->
//            }, this::handleError)
//        }
    }

}