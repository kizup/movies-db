package com.example.feature.home.screen.presentation.view

import android.os.Bundle
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.feature.home.screen.R
import com.example.feature.home.screen.di.DaggerHomeComponent
import com.example.feature.home.screen.presentation.model.CarouselItem
import com.example.feature.home.screen.presentation.model.HeaderItem
import com.example.feature.home.screen.presentation.model.HomeTabScreenData
import com.example.feature.home.screen.presentation.model.SpaceItem
import com.example.feature.home.screen.presentation.mvp.HomePresenter
import com.example.feature.home.screen.utils.plusAssign
import com.example.moviesdb.presentation.view.base.BaseFragment
import com.example.moviesdb.presentation.view.base.IBaseView
import com.example.moviesdb.presentation.view.base.ILoadingView
import com.example.moviesdb.utils.findComponentDependencies
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder
import kotlinx.android.synthetic.main.fragment_home.*
import moxy.ktx.moxyPresenter
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.OneExecutionStateStrategy
import moxy.viewstate.strategy.StateStrategyType

interface IHomeView : IBaseView, ILoadingView {

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun setMoviesData(data: HomeTabScreenData)

}

class HomeFragment : BaseFragment<HomePresenter>(), IHomeView {

    override fun performInject() {
        DaggerHomeComponent
            .builder()
            .homeDependencies(findComponentDependencies())
            .build()
            .inject(this)
    }

    private val presenter: HomePresenter
            by moxyPresenter { lazyPresenter.get() }

    private lateinit var linearLayoutManager: LinearLayoutManager
    private val groupAdapter: GroupAdapter<GroupieViewHolder> by lazy {
        GroupAdapter<GroupieViewHolder>().apply {
            setHasStableIds(true)
        }
    }

    override val layoutId: Int
        get() = R.layout.fragment_home

    override fun initView(view: View, savedInstanceState: Bundle?) {
        linearLayoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        initRecyclerView()
    }

    private fun initRecyclerView() {
        rvHome.apply {
            layoutManager = linearLayoutManager
            isNestedScrollingEnabled = false
            adapter = groupAdapter
        }
        groupAdapter.clear()
    }

    override fun setMoviesData(data: HomeTabScreenData) {
        data.apply {
            allMovies.apply {
                groupAdapter += HeaderItem(getString(R.string.top_rated_movies_title))
                groupAdapter += CarouselItem(topRated) { presenter.onItemClick(it) }

                groupAdapter += SpaceItem

                groupAdapter += HeaderItem(getString(R.string.popular_movies_title))
                groupAdapter += CarouselItem(popular) { presenter.onItemClick(it) }

                groupAdapter += SpaceItem

                groupAdapter += HeaderItem(getString(R.string.now_playing_movies_title))
                groupAdapter += CarouselItem(nowPlaying) { presenter.onItemClick(it) }

                groupAdapter += SpaceItem

                groupAdapter += HeaderItem(getString(R.string.upcoming_movies_title))
                groupAdapter += CarouselItem(upcoming) { presenter.onItemClick(it) }
            }

            groupAdapter.add(SpaceItem)

            tvShows.apply {
                groupAdapter += HeaderItem(getString(R.string.tv_title))
                groupAdapter += HeaderItem(getString(R.string.top_rated_movies_title))
                groupAdapter += CarouselItem(tvTopRated) { presenter.onItemClick(it) }

                groupAdapter += SpaceItem

                groupAdapter += HeaderItem(getString(R.string.popular_movies_title))
                groupAdapter += CarouselItem(tvPopular) { presenter.onItemClick(it) }

                groupAdapter += SpaceItem
            }
        }
    }

}