package com.example.feature.home.screen.presentation.mvp

import com.example.feature.home.screen.presentation.model.*
import com.example.feature.home.screen.presentation.view.IHomeView
import com.example.moviesdb.network.api.TheMovieDBClientApi
import com.example.moviesdb.network.model.Movie
import com.example.moviesdb.network.model.MovieType
import com.example.moviesdb.network.model.TvShow
import com.example.moviesdb.network.model.TvShowType
import com.example.moviesdb.presentation.mvp.base.BasePresenter
import com.example.moviesdb.utils.ioToUi
import com.example.moviesdb.utils.loading
import com.xwray.groupie.kotlinandroidextensions.Item
import io.reactivex.Single
import io.reactivex.functions.BiFunction
import io.reactivex.functions.Function4
import moxy.InjectViewState
import javax.inject.Inject

@InjectViewState
class HomePresenter @Inject constructor(
    private val tmdbClient: TheMovieDBClientApi
) : BasePresenter<IHomeView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        loadContent()
    }

    override fun retry() {
        super.retry()
        loadContent()
    }

    private fun loadContent() {
        launch {
            Single.zip(
                loadMovies(),
                loadTvShows(),
                BiFunction<AllMovies, AllTvShows, HomeTabScreenData> { movies, tvShows ->
                    HomeTabScreenData(
                        movies,
                        tvShows
                    )
                }
            )
                .ioToUi()
                .loading(viewState)
                .subscribe({ data ->
                    viewState.setMoviesData(data)
                }, this::handleError)

        }
    }

    private fun loadMovies(): Single<AllMovies> {
        return Single.zip(
            tmdbClient.loadMovies(MovieType.Popular),
            tmdbClient.loadMovies(MovieType.NowPlaying),
            tmdbClient.loadMovies(MovieType.TopRated),
            tmdbClient.loadMovies(MovieType.Upcoming),
            Function4<List<Movie>, List<Movie>, List<Movie>, List<Movie>, AllMovies> { popular, nowPlaying, topRated, upcoming ->
                AllMovies(
                    popular.map { MovieItem(it) },
                    nowPlaying.map { MovieItem(it) },
                    topRated.map { MovieItem(it) },
                    upcoming.map { MovieItem(it) }
                )
            }
        )
    }

    private fun loadTvShows(): Single<AllTvShows> {
        return Single.zip(
            tmdbClient.loadTvShows(TvShowType.TopRated),
            tmdbClient.loadTvShows(TvShowType.Popular),
            BiFunction<List<TvShow>, List<TvShow>, AllTvShows> { topRates, popular ->
                AllTvShows(
                    topRates.map { TvShowItem(it) },
                    popular.map { TvShowItem(it) }
                )
            }
        )
    }

    fun onItemClick(item: Item) {
    }
}