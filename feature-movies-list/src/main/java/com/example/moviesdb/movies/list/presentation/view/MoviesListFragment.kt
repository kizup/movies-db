package com.example.moviesdb.movies.list.presentation.view

import com.example.moviesdb.movies.list.R
import com.example.moviesdb.movies.list.di.DaggerMoviesListComponent
import com.example.moviesdb.movies.list.presentation.mvp.MoviesListPresenter
import com.example.moviesdb.presentation.view.base.BaseFragment
import com.example.moviesdb.utils.findComponentDependencies
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter

class MoviesListFragment : BaseFragment<MoviesListPresenter>() {

    @InjectPresenter lateinit var presenter: MoviesListPresenter
    @ProvidePresenter fun providePresenter(): MoviesListPresenter = lazyPresenter.get()

    override fun performInject() {
        DaggerMoviesListComponent.builder()
            .moviesListDependencies(findComponentDependencies())
            .build()
            .inject(this)
    }

    override val layoutId: Int
        get() = R.layout.fragment_movies_list
}