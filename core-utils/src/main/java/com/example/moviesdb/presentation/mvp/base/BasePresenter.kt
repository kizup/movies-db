package com.example.moviesdb.presentation.mvp.base

import com.example.moviesdb.presentation.view.base.IBaseView
import com.example.moviesdb.presentation.view.base.ILoadingView
import com.example.moviesdb.utils.BuildConfig
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import moxy.MvpPresenter

abstract class BasePresenter<View: IBaseView> : MvpPresenter<View>() {

    private val compositeDisposable: CompositeDisposable = CompositeDisposable()

    /**
     * Flag shows can this presenter manage error loading container
     * If you want handle errors by other method, set this flag to [false]
     */
    protected var canUpdateErrorContainer: Boolean = true

    protected open fun handleError(t: Throwable) {
        if (canUpdateErrorContainer && viewState is ILoadingView) {
            (viewState as ILoadingView).showErrorByLoading(true)
        }

        if (BuildConfig.DEBUG) {
            t.printStackTrace()
        }
    }

    protected fun launch(disposable: () -> Disposable) {
        if (canUpdateErrorContainer && viewState is ILoadingView) {
            (viewState as ILoadingView).showErrorByLoading(false)
        }
        compositeDisposable.add(disposable())
    }

    override fun onDestroy() {
        compositeDisposable.clear()
        super.onDestroy()
    }

    open fun retry() {}

    open fun back() {}

}