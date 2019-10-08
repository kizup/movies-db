package com.example.moviesdb.presentation.view.base

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

interface IBaseView : MvpView {

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun showMessage(messageId: Int)

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun showMessage(message: String)

}