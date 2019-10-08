package com.example.moviesdb.presentation.mvp.base

import com.example.moviesdb.presentation.view.base.IBaseView
import com.example.moviesdb.utils.BuildConfig
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import moxy.MvpPresenter

abstract class BasePresenter<View: IBaseView> : MvpPresenter<View>() {

    private val compositeDisposable: CompositeDisposable = CompositeDisposable()

    protected fun handleError(t: Throwable) {
        if (BuildConfig.DEBUG) {
            t.printStackTrace()
        }
    }

    protected fun launch(disposable: () -> Disposable) {
        compositeDisposable.add(disposable())
    }

    override fun onDestroy() {
        compositeDisposable.clear()
        super.onDestroy()
    }

}