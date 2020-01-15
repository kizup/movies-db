package com.example.moviesdb.presentation.view.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import com.blankj.utilcode.util.ToastUtils
import dagger.Lazy
import moxy.MvpAppCompatFragment
import com.example.moviesdb.presentation.mvp.base.BasePresenter
import com.example.moviesdb.utils.R
import com.example.moviesdb.utils.gone
import com.example.moviesdb.utils.visibleOrGone
import kotlinx.android.synthetic.main.error_loading_with_retry_button.view.*
import kotlinx.android.synthetic.main.loading.view.*
import javax.inject.Inject

abstract class BaseFragment<Presenter: BasePresenter<*>> : MvpAppCompatFragment(),
    IBaseView, ILoadingView {

    @Inject
    open lateinit var lazyPresenter: Lazy<Presenter>

    abstract val layoutId: Int
    abstract fun performInject()

    private var errorLoadContainer: ViewGroup? = null

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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initErrorRetryContainer(view)
    }

    override fun showMessage(messageId: Int) {
        ToastUtils.showShort(messageId)
    }

    override fun showMessage(message: String) {
        ToastUtils.showShort(message)
    }

    open fun onBackPressed() {}

    override fun showLoading(loading: Boolean) {
        view?.findViewById<View>(R.id.loading_container)?.visibleOrGone(loading)
    }

    override fun showErrorByLoading(show: Boolean) {
        errorLoadContainer?.visibleOrGone(show)
    }

    private fun initErrorRetryContainer(view: View) {
        errorLoadContainer = view.findViewById(R.id.error_container)
        errorLoadContainer?.gone()
        errorLoadContainer?.bn_retry?.setOnClickListener { lazyPresenter.get().retry() }
    }

}