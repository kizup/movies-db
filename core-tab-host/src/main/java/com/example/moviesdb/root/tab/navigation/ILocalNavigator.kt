package com.example.moviesdb.root.tab.navigation

import ru.terrakok.cicerone.Router
import ru.terrakok.cicerone.android.support.SupportAppScreen

interface ILocalNavigator {

    fun setRouter(router: Router)
    fun navigateTo(screen: SupportAppScreen)
    fun root(screen: SupportAppScreen)
    fun exit()

}