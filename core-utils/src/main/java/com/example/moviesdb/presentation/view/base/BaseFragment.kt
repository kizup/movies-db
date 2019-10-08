package com.example.moviesdb.presentation.view.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.blankj.utilcode.util.ToastUtils
import dagger.Lazy
import moxy.MvpAppCompatFragment
import com.example.moviesdb.presentation.mvp.base.BasePresenter
import javax.inject.Inject

abstract class BaseFragment<Presenter: BasePresenter<*>> : MvpAppCompatFragment(), IBaseView {

    @Inject
    open lateinit var lazyPresenter: Lazy<Presenter>

    abstract val layoutId: Int
    abstract fun performInject()

    override fun onCreate(savedInstanceState: Bundle?) {
        performInject()
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(layoutId, container, false)
    }

    override fun showMessage(messageId: Int) {
        ToastUtils.showShort(messageId)
    }

    override fun showMessage(message: String) {
        ToastUtils.showShort(message)
    }
}