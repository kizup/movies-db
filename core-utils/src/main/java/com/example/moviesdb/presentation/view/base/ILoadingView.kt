package com.example.moviesdb.presentation.view.base

import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

interface ILoadingView {

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun showLoading(loading: Boolean)

}