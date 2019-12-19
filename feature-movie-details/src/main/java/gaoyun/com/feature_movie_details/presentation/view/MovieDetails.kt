package gaoyun.com.feature_movie_details.presentation.view

import com.example.moviesdb.presentation.view.base.BaseFragment
import com.example.moviesdb.presentation.view.base.IBaseView
import com.example.moviesdb.utils.findComponentDependencies
import gaoyun.com.feature_movie_details.di.DaggerMovieDetailsComponent
import gaoyun.com.feature_movie_details.presentation.mvp.MovieDetailsPresenter
import moxy.ktx.moxyPresenter

interface MovieDetailsView : IBaseView {

}

class MovieDetailsFragment : BaseFragment<MovieDetailsPresenter>(), MovieDetailsView {

    override val layoutId: Int
        get() = 0

    override fun performInject() =
        DaggerMovieDetailsComponent
            .builder()
            .movieDetailsDependencies(findComponentDependencies())
            .build()
            .inject(this)

    val presenter: MovieDetailsPresenter by moxyPresenter { lazyPresenter.get() }

}