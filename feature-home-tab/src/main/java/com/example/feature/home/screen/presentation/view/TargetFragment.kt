package com.example.feature.home.screen.presentation.view

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.feature.home.screen.R
import com.example.feature.home.screen.di.DaggerHomeComponent
import com.example.moviesdb.presentation.mvp.base.BasePresenter
import com.example.moviesdb.presentation.view.base.BaseFragment
import com.example.moviesdb.presentation.view.base.IBaseView
import com.example.moviesdb.root.tab.navigation.ILocalNavigator
import com.example.moviesdb.utils.findComponentDependencies
import moxy.InjectViewState
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter
import javax.inject.Inject

@InjectViewState
class TargetPresenter @Inject constructor(
    private val localNavigator: ILocalNavigator
) : BasePresenter<IBaseView>() {

}

class TargetFragment : BaseFragment<TargetPresenter>(), IBaseView {

    @InjectPresenter
    lateinit var presenter: TargetPresenter

    @ProvidePresenter
    fun providePresenter(): TargetPresenter = lazyPresenter.get()

    override fun performInject() {
        DaggerHomeComponent.builder()
            .homeDependencies(findComponentDependencies())
            .build()
            .inject(this)
    }

    override val layoutId: Int
        get() = R.layout.fragment_home

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.setBackgroundColor(Color.BLACK)
    }

}