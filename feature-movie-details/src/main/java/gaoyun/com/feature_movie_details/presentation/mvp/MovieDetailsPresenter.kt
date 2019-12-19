package gaoyun.com.feature_movie_details.presentation.mvp

import com.example.moviesdb.network.api.TheMovieDBClientApi
import com.example.moviesdb.presentation.mvp.base.BasePresenter
import com.example.moviesdb.root.tab.navigation.ILocalNavigator
import gaoyun.com.feature_movie_details.presentation.view.MovieDetailsView
import moxy.InjectViewState
import javax.inject.Inject

@InjectViewState
class MovieDetailsPresenter @Inject constructor(
    private val tmdbClient: TheMovieDBClientApi,
    private val localNavigator: ILocalNavigator
) : BasePresenter<MovieDetailsView>() {
}