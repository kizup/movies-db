package com.example.moviesdb.movies.list.presentation.view

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.moviesdb.movies.list.R
import com.example.moviesdb.movies.list.di.DaggerMoviesListComponent
import com.example.moviesdb.movies.list.presentation.mvp.MoviesListPresenter
import com.example.moviesdb.presentation.view.base.BaseFragment
import com.example.moviesdb.utils.findComponentDependencies
import kotlinx.android.synthetic.main.fragment_movies_list.*
import moxy.ktx.moxyPresenter

class MoviesListFragment : BaseFragment<MoviesListPresenter>(), IMoviesListView {

    val presenter: MoviesListPresenter by moxyPresenter { lazyPresenter.get() }

    override fun performInject() {
        DaggerMoviesListComponent.builder()
            .moviesListDependencies(findComponentDependencies())
            .build()
            .inject(this)
    }


    override val layoutId: Int
        get() = R.layout.fragment_movies_list

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rvMoviesList.apply {
            layoutManager = LinearLayoutManager(context)
            addItemDecoration(DividerItemDecoration(context, RecyclerView.VERTICAL))
        }
    }

}