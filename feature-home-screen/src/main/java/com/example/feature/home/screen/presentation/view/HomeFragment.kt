package com.example.feature.home.screen.presentation.view

import com.example.feature.home.screen.R
import com.example.feature.home.screen.di.DaggerHomeComponent
import com.example.feature.home.screen.presentation.mvp.HomePresenter
import com.example.moviesdb.presentation.view.base.BaseFragment
import com.example.moviesdb.utils.findComponentDependencies
import moxy.ktx.moxyPresenter

class HomeFragment : BaseFragment<HomePresenter>(), IHomeView {

    override fun performInject() {
        DaggerHomeComponent.builder()
            .homeDependencies(findComponentDependencies())
            .build().inject(this)
    }

    val presenter: HomePresenter by moxyPresenter { lazyPresenter.get() }

    override val layoutId: Int
        get() = R.layout.fragment_home


}