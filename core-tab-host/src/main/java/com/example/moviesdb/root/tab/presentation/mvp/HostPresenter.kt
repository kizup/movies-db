package com.example.moviesdb.root.tab.presentation.mvp

import com.example.moviesdb.presentation.mvp.base.BasePresenter
import com.example.moviesdb.root.tab.presentation.view.IHostView
import moxy.InjectViewState
import javax.inject.Inject

@InjectViewState
class HostPresenter @Inject constructor() : BasePresenter<IHostView>() {

}