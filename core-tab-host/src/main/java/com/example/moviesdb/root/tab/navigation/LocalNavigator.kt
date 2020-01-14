package com.example.moviesdb.root.tab.navigation

import ru.terrakok.cicerone.Router
import ru.terrakok.cicerone.android.support.SupportAppScreen

class LocalNavigator : ILocalNavigator {

    lateinit var localRouter: Router

    override fun setRouter(router: Router) {
        localRouter = router
    }

    override fun navigateTo(screen: SupportAppScreen) = localRouter.navigateTo(screen)
    override fun root(screen: SupportAppScreen) = localRouter.newRootScreen(screen)
    override fun exit() = localRouter.exit()
}