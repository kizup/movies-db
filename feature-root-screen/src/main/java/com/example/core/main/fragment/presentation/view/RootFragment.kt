package com.example.core.main.fragment.presentation.view

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.navigation.ui.setupWithNavController
import com.example.core.main.fragment.R
import com.example.core.main.fragment.di.DaggerRootComponent
import com.example.core.main.fragment.di.RootNavigationModule
import com.example.core.main.fragment.navigation.RootNavigation
import com.example.core.main.fragment.presentation.mvp.RootPresenter
import com.example.core.main.utils.setupWithNavController
import com.example.moviesdb.presentation.view.base.BaseFragment
import com.example.moviesdb.utils.findComponentDependencies
import com.google.android.material.bottomnavigation.BottomNavigationView
import moxy.ktx.moxyPresenter
import javax.inject.Inject

class RootFragment : BaseFragment<RootPresenter>() {

    val presenter: RootPresenter by moxyPresenter { lazyPresenter.get() }

    @Inject
    lateinit var rootNavigation: RootNavigation

    override fun performInject() {
        DaggerRootComponent.builder()
            .rootDependencies(findComponentDependencies())
            .build()
            .inject(this)
    }

    override val layoutId: Int
        get() = R.layout.fragment_main

    override fun initView(view: View, savedInstanceState: Bundle?) {
        with(view.findViewById<BottomNavigationView>(R.id.bottomBar)) {
            val navGraphIds = listOf(
                R.navigation.home,
                R.navigation.search,
                R.navigation.trailers,
                R.navigation.account
            )
            setupWithNavController(navGraphIds, childFragmentManager, R.id.mainScreenContainer)
                .observe(this@RootFragment, Observer { navController ->
                    rootNavigation.navController = navController
                })
        }
    }
}