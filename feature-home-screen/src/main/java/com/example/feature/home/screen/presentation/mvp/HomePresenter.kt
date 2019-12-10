package com.example.feature.home.screen.presentation.mvp

import com.example.feature.home.screen.presentation.view.IHomeView
import com.example.moviesdb.network.api.TheMovieDBClientApi
import com.example.moviesdb.presentation.mvp.base.BasePresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import moxy.InjectViewState
import javax.inject.Inject

@InjectViewState
class HomePresenter @Inject constructor(
    private val tmdbClient: TheMovieDBClientApi
): BasePresenter<IHomeView>() {

    override fun attachView(view: IHomeView?) {
        super.attachView(view)

    }

    private fun loadNowPlayingMovies() {
        launch { tmdbClient.loadPopularMovies()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ movies ->
//                viewState.addData(movies.map { MovieI })
            })

        }
    }
}