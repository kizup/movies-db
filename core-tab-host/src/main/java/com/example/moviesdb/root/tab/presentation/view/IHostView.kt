package com.example.moviesdb.root.tab.presentation.view

import com.example.moviesdb.presentation.view.base.IBaseView
import moxy.viewstate.strategy.OneExecutionStateStrategy
import moxy.viewstate.strategy.StateStrategyType
import ru.terrakok.cicerone.android.support.SupportAppScreen

interface IHostView : IBaseView {

    @StateStrategyType(OneExecutionStateStrategy::class)
    fun localNavigateTo(screen : SupportAppScreen)

}