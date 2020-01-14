package com.example.moviesdb.root.tab.presentation.view

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.moviesdb.presentation.view.base.BaseFragment
import com.example.moviesdb.root.tab.R
import com.example.moviesdb.root.tab.di.components.DaggerTabHostComponent
import com.example.moviesdb.root.tab.di.modules.NavigatorModule
import com.example.moviesdb.root.tab.di.scope.TabHostScope
import com.example.moviesdb.root.tab.navigation.ILocalNavigator
import com.example.moviesdb.root.tab.presentation.mvp.HostPresenter
import com.example.moviesdb.utils.findComponentDependencies
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.Navigator
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.Router
import ru.terrakok.cicerone.android.support.SupportAppNavigator
import ru.terrakok.cicerone.android.support.SupportAppScreen
import ru.terrakok.cicerone.commands.Command
import javax.inject.Inject
import javax.inject.Singleton

class HostFragment : BaseFragment<HostPresenter>(),
    IHostView {

    @Inject
    lateinit var cicerone: Cicerone<Router>

    @Inject
    lateinit var navigatorHolder: NavigatorHolder

    @Inject
    @TabHostScope
    lateinit var localNavigator: ILocalNavigator

    private val navigator: Navigator by lazy {
        object : SupportAppNavigator(activity, childFragmentManager, R.id.host_container) {
            override fun setupFragmentTransaction(
                command: Command?,
                currentFragment: Fragment?,
                nextFragment: Fragment?,
                fragmentTransaction: FragmentTransaction?
            ) {
                fragmentTransaction?.setReorderingAllowed(true)
            }
        }
    }

    override val layoutId: Int
        get() = R.layout.fragment_tab_host

    override fun performInject() {
        DaggerTabHostComponent.builder()
            .tabHostDependencies(findComponentDependencies())
            .navigatorModule(NavigatorModule())
            .build()
            .inject(this)
        localNavigator.setRouter(cicerone.router)
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

    override fun localSetRoot(screen: SupportAppScreen) {
        localNavigator.root(screen)
    }

    override fun onBackPressed() {
        localNavigator.exit()
    }

}