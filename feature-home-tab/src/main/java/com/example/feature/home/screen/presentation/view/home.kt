package com.example.feature.home.screen.presentation.view

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.feature.home.screen.R
import com.example.feature.home.screen.di.DaggerHomeComponent
import com.example.feature.home.screen.presentation.model.*
import com.example.feature.home.screen.presentation.mvp.HomePresenter
import com.example.feature.home.screen.utils.plusAssign
import com.example.moviesdb.presentation.view.base.BaseFragment
import com.example.moviesdb.presentation.view.base.IBaseView
import com.example.moviesdb.utils.findComponentDependencies
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder
import kotlinx.android.synthetic.main.fragment_home.*
import moxy.ktx.moxyPresenter
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

interface IHomeView : IBaseView {

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun setMoviesData(data: HomeTabScreenData)

}

class HomeFragment : BaseFragment<HomePresenter>(), IHomeView {

    override fun performInject() {
        DaggerHomeComponent.builder()
            .homeDependencies(findComponentDependencies())
            .build()
            .inject(this)
    }

    val presenter: HomePresenter by moxyPresenter { lazyPresenter.get() }

    private lateinit var linearLayoutManager: LinearLayoutManager
    private val groupAdapter: GroupAdapter<GroupieViewHolder> by lazy { GroupAdapter<GroupieViewHolder>() }

    override val layoutId: Int
        get() = R.layout.fragment_home

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        linearLayoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        initRecyclerView()
    }

    private fun initRecyclerView() {
        groupAdapter.setHasStableIds(true)
        rvHome.apply {
            layoutManager = linearLayoutManager
            setHasFixedSize(false)
            isNestedScrollingEnabled = false
            adapter = groupAdapter
        }
        groupAdapter.clear()
    }

    override fun setMoviesData(data: HomeTabScreenData) {
        data.apply {
            allMovies.apply {
                groupAdapter += HeaderItem(getString(R.string.top_rated_movies_title))
                { presenter.navigateToAllItems(MovieListType.TopRatedMovies) }
                groupAdapter += CarouselItem(topRated)

                groupAdapter += SpaceItem

                groupAdapter += HeaderItem(getString(R.string.popular_movies_title))
                { presenter.navigateToAllItems(MovieListType.PopularMovies) }
                groupAdapter += CarouselItem(popular)

                groupAdapter += SpaceItem

                groupAdapter += HeaderItem(getString(R.string.now_playing_movies_title))
                { presenter.navigateToAllItems(MovieListType.NowPlayingMovies) }
                groupAdapter += CarouselItem(nowPlaying)

                groupAdapter += SpaceItem

                groupAdapter += HeaderItem(getString(R.string.upcoming_movies_title))
                { presenter.navigateToAllItems(MovieListType.UpcomingMovies) }
                groupAdapter += CarouselItem(upcoming)
            }

            groupAdapter.add(SpaceItem)

            tvShows.apply {
                groupAdapter += HeaderItem(getString(R.string.tv_title))
                { presenter.navigateToAllItems(MovieListType.TEST) }
                groupAdapter += HeaderItem(getString(R.string.top_rated_movies_title))
                { presenter.navigateToAllItems(MovieListType.TEST) }
                groupAdapter += CarouselItem(tvTopRated)

                groupAdapter += SpaceItem

                groupAdapter += HeaderItem(getString(R.string.popular_movies_title))
                { presenter.navigateToAllItems(MovieListType.TEST) }
                groupAdapter += CarouselItem(tvPopular)

                groupAdapter += SpaceItem
            }
        }
    }
}