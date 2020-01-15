package com.example.moviesdb

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.moviesdb.movies.list.di.DaggerAppComponent
import com.example.moviesdb.movies.list.di.RetrofitNetworkModule
import com.example.moviesdb.movies.list.di.modules.NavigatorModule
import com.example.moviesdb.presentation.view.base.BaseFragment
import com.example.moviesdb.utils.ComponentDependenciesProvider
import com.example.moviesdb.utils.HasComponentDependencies
import ru.terrakok.cicerone.Navigator
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.android.support.SupportAppNavigator
import ru.terrakok.cicerone.commands.Command
import javax.inject.Inject

class MainActivity : AppCompatActivity(), HasComponentDependencies {

    @Inject
    override lateinit var dependencies: ComponentDependenciesProvider
    @Inject
    lateinit var navigatorHolder: NavigatorHolder

    private val currentFragment: BaseFragment<*>?
        get() = supportFragmentManager.fragments.firstOrNull { !it.isHidden } as? BaseFragment<*>

    private val navigator: Navigator =
        object : SupportAppNavigator(this, supportFragmentManager, R.id.container) {
            override fun setupFragmentTransaction(
                command: Command?,
                currentFragment: Fragment?,
                nextFragment: Fragment?,
                fragmentTransaction: FragmentTransaction?
            ) {
                fragmentTransaction?.setReorderingAllowed(true)
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        performInject()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        navigatorHolder.removeNavigator()
        super.onPause()
    }

    override fun onBackPressed() {
        currentFragment?.onBackPressed() ?: super.onBackPressed()
    }

    private fun performInject() {
        DaggerAppComponent.builder()
            .navigatorModule(NavigatorModule())
            .retrofitNetworkModule(RetrofitNetworkModule())
            .build()
            .inject(this)
    }

}
