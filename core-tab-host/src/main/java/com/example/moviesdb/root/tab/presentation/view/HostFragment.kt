package com.example.moviesdb.root.tab.presentation.view

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.moviesdb.presentation.view.base.BaseFragment
import com.example.moviesdb.root.tab.R
import com.example.moviesdb.root.tab.di.components.DaggerTabHostComponent
import com.example.moviesdb.root.tab.navigation.ILocalNavigator
import com.example.moviesdb.root.tab.presentation.mvp.HostPresenter
import com.example.moviesdb.utils.ComponentDependenciesProvider
import com.example.moviesdb.utils.HasComponentDependencies
import ru.terrakok.cicerone.Navigator
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.android.support.SupportAppNavigator
import ru.terrakok.cicerone.android.support.SupportAppScreen
import ru.terrakok.cicerone.commands.Command
import javax.inject.Inject

class HostFragment : BaseFragment<HostPresenter>(),
    HasComponentDependencies,
    IHostView {

    @Inject
    override lateinit var dependencies: ComponentDependenciesProvider

    @Inject
    lateinit var navigatorHolder: NavigatorHolder

    @Inject
    lateinit var localNavigator: ILocalNavigator

    private val navigator: Navigator =
        object : SupportAppNavigator(activity, childFragmentManager, R.id.host_container) {
            override fun setupFragmentTransaction(
                command: Command?,
                currentFragment: Fragment?,
                nextFragment: Fragment?,
                fragmentTransaction: FragmentTransaction?
            ) {

            }
        }

    override val layoutId: Int
        get() = R.layout.fragment_tab_host

    override fun performInject() {
        DaggerTabHostComponent.builder()
            .build()
            .inject(this)
    }

    override fun onResume() {
        super.onResume()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        navigatorHolder.removeNavigator()
        super.onPause()
    }

    override fun localNavigateTo(screen: SupportAppScreen) {
        localNavigator.navigateTo(screen)
    }
}