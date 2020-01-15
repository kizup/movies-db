package com.example.moviesdb.root.tab.di.modules

import com.example.moviesdb.root.tab.di.scope.TabHostScope
import com.example.moviesdb.root.tab.navigation.ILocalNavigator
import com.example.moviesdb.root.tab.navigation.LocalNavigator
import dagger.Module
import dagger.Provides
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.Router

@Module
class NavigatorModule {

    private val cicerone: Cicerone<Router> = Cicerone.create()

    @Provides
    @TabHostScope
    fun provideLocalNavigator(): ILocalNavigator {
        return LocalNavigator()
    }

    @Provides
    fun provideNavigatorHolder(): NavigatorHolder {
        return cicerone.navigatorHolder
    }

    @Provides
    fun provideRouter(): Router {
        return cicerone.router
    }

    @Provides
    fun provideCicerone(): Cicerone<Router> {
        return cicerone
    }

}