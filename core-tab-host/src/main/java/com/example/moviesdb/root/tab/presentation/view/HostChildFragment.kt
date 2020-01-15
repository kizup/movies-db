package com.example.moviesdb.root.tab.presentation.view

import com.example.moviesdb.presentation.mvp.base.BasePresenter
import com.example.moviesdb.presentation.view.base.BaseFragment
import com.example.moviesdb.root.tab.navigation.ILocalNavigator

/**
 * All children fragments in host fragment must extends this fragment for local
 * host navigation correctly working
 */
abstract class HostChildFragment<Presenter: BasePresenter<*>> : BaseFragment<Presenter>() {

    /**
     * This link in local navigator from parent host fragment,
     * this link is redirected inside a child presenter
     */
    protected val parentNavigator: ILocalNavigator
            by lazy { (parentFragment as HostFragment).localNavigator }

}