package com.example.core.main.fragment.presentation.mvp

import com.example.core.main.fragment.presentation.view.IMainView
import com.example.moviesdb.presentation.mvp.base.BasePresenter
import moxy.InjectViewState
import javax.inject.Inject

@InjectViewState
class RootPresenter @Inject constructor() : BasePresenter<IMainView>() {

}