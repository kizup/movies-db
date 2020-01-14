package com.example.feature.home.screen.presentation.mvp

import androidx.fragment.app.Fragment
import com.example.feature.home.screen.presentation.model.*
import com.example.feature.home.screen.presentation.view.IHomeView
import com.example.feature.home.screen.presentation.view.TargetFragment
import com.example.moviesdb.network.api.TheMovieDBClientApi
import com.example.moviesdb.network.model.Movie
import com.example.moviesdb.network.model.MovieType
import com.example.moviesdb.network.model.TvShow
import com.example.moviesdb.network.model.TvShowType
import com.example.moviesdb.presentation.mvp.base.BasePresenter
import com.example.moviesdb.root.tab.di.scope.TabHostScope
import com.example.moviesdb.root.tab.navigation.ILocalNavigator
import com.xwray.groupie.GroupieViewHolder
import com.xwray.groupie.Item
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.BiFunction
import io.reactivex.functions.Function4
import io.reactivex.schedulers.Schedulers
import moxy.InjectViewState
import ru.terrakok.cicerone.android.support.SupportAppScreen
import javax.inject.Inject

@InjectViewState
class HomePresenter @Inject constructor(
    private val tmdbClient: TheMovieDBClientApi,
    @TabHostScope private val localNavigator: ILocalNavigator
) : BasePresenter<IHomeView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        loadNowPlayingMovies()
    }

    private fun loadNowPlayingMovies() {
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
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
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

    fun onItemClick(item: Item<GroupieViewHolder>) {
        localNavigator.navigateTo(object : SupportAppScreen() {
            override fun getFragment(): Fragment {
                return TargetFragment()
            }
        })
    }
}