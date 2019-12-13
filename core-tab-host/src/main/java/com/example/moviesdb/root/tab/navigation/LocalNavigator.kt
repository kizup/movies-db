package com.example.moviesdb.root.tab.navigation

import ru.terrakok.cicerone.Router
import ru.terrakok.cicerone.android.support.SupportAppScreen

class LocalNavigator(
    private val router: Router
) : ILocalNavigator {

    override fun navigateTo(screen: SupportAppScreen) {
        router.navigateTo(screen)
    }
}