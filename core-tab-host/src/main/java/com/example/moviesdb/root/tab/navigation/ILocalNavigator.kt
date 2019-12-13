package com.example.moviesdb.root.tab.navigation

import ru.terrakok.cicerone.android.support.SupportAppScreen

interface ILocalNavigator {

    fun navigateTo(screen: SupportAppScreen)

    fun root(screen: SupportAppScreen)

}