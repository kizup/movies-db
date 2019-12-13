package com.example.core.main.fragment.presentation.view

import android.os.Bundle
import androidx.core.content.ContextCompat
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationAdapter
import com.example.core.main.Screens
import com.example.core.main.fragment.R
import com.example.core.main.fragment.di.DaggerRootComponent
import com.example.core.main.fragment.presentation.mvp.RootPresenter
import com.example.moviesdb.presentation.view.base.BaseFragment
import com.example.moviesdb.utils.findComponentDependencies
import kotlinx.android.synthetic.main.fragment_main.*
import moxy.ktx.moxyPresenter
import ru.terrakok.cicerone.android.support.SupportAppScreen

class RootFragment : BaseFragment<RootPresenter>() {

    val presenter: RootPresenter by moxyPresenter { lazyPresenter.get() }

    override fun performInject() {
        DaggerRootComponent.builder()
            .rootDependencies(findComponentDependencies())
            .build().inject(this)
    }

    override val layoutId: Int
        get() = R.layout.fragment_main

    private val currentTabFragment: BaseFragment<*>?
        get() = childFragmentManager.fragments.firstOrNull { !it.isHidden } as? BaseFragment<*>


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        AHBottomNavigationAdapter(activity, R.menu.main_bottom_menu).apply {
            setupWithBottomNavigation(bottomBar)
        }
        with(bottomBar) {
            accentColor = ContextCompat.getColor(context, R.color.color_red_rose)
            inactiveColor = ContextCompat.getColor(context, R.color.color_inactive)

            setOnTabSelectedListener { position, wasSelected ->
                if (!wasSelected) selectTab(
                    when (position) {
                        0 -> homeTab
                        1 -> searchTab
                        2 -> trailersTab
                        3 -> accountTab
                        else -> homeTab
                    }
                )
                true
            }
//            val leftMargin = resources.getDimension(R.dimen.bottom_bar_notification_left_margin).toInt()
//            setNotificationMarginLeft(leftMargin, leftMargin)
        }

        selectTab(
            when (currentTabFragment?.tag) {
                homeTab.screenKey -> homeTab
                searchTab.screenKey -> searchTab
                trailersTab.screenKey -> trailersTab
                accountTab.screenKey -> accountTab
                else -> homeTab
            }
        )
    }

    private fun createTabFragment(tab: SupportAppScreen) = tab.fragment

    private fun selectTab(tab: SupportAppScreen) {

        val currentFragment = currentTabFragment
        val newFragment = childFragmentManager.findFragmentByTag(tab.screenKey)

        if (currentFragment != null && newFragment != null && currentFragment == newFragment) return

        childFragmentManager.beginTransaction().apply {
            if (newFragment == null) add(R.id.mainScreenContainer, createTabFragment(tab), tab.screenKey)

            currentFragment?.let {
                hide(it)
                it.userVisibleHint = false
            }
            newFragment?.let {
                show(it)
                it.userVisibleHint = true
            }
        }.commitNow()
    }

    companion object {
        private val homeTab = Screens.Home
        private val searchTab = Screens.Search
        private val trailersTab = Screens.Trailers
        private val accountTab = Screens.Account
    }
}