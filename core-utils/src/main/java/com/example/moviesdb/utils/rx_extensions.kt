package com.example.moviesdb.utils

import com.example.moviesdb.presentation.view.base.ILoadingView
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

fun <T> Observable<T>.ioToUi(): Observable<T> = subscribeOn(Schedulers.io())
    .observeOn(AndroidSchedulers.mainThread())

fun <T> Single<T>.ioToUi(): Single<T> = subscribeOn(Schedulers.io())
    .observeOn(AndroidSchedulers.mainThread())

fun Completable.ioToUi(): Completable = subscribeOn(Schedulers.io())
    .observeOn(AndroidSchedulers.mainThread())

fun <T> Observable<T>.loading(loadingView: ILoadingView): Observable<T>
        = doOnSubscribe { loadingView.showLoading(true) }
            .doOnError { loadingView.showLoading(false) }
            .doOnComplete { loadingView.showLoading(false) }

fun <T> Single<T>.loading(loadingView: ILoadingView): Single<T>
        = doOnSubscribe { loadingView.showLoading(true) }
            .doOnError { loadingView.showLoading(false) }
            .doOnSuccess { loadingView.showLoading(false) }