package com.example.feature.home.screen.presentation.view

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.feature.home.screen.R
import com.example.feature.home.screen.di.DaggerHomeComponent
import com.example.feature.home.screen.presentation.model.HeaderItem
import com.example.feature.home.screen.presentation.mvp.HomePresenter
import com.example.moviesdb.presentation.view.base.BaseFragment
import com.example.moviesdb.presentation.view.base.IBaseView
import com.example.moviesdb.utils.findComponentDependencies
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder
import com.xwray.groupie.Section
import kotlinx.android.synthetic.main.fragment_home.*
import moxy.ktx.moxyPresenter

interface IHomeView : IBaseView {

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
    private val groupAdapter: GroupAdapter<out GroupieViewHolder> by lazy { GroupAdapter<GroupieViewHolder>() }

    override val layoutId: Int
        get() = R.layout.fragment_home

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        linearLayoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        initRecyclerView()
    }

    private fun initRecyclerView() {
        rvHome.apply {
            layoutManager = linearLayoutManager
            setHasFixedSize(false)
            isNestedScrollingEnabled = false
            adapter = groupAdapter
        }

        val header = HeaderItem("First")
        groupAdapter.add(header)
    }

}