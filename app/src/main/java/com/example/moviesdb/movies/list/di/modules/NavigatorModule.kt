package com.example.moviesdb.movies.list.di.modules

import com.example.moviesdb.movies.list.api.MoviesListNavigator
import com.example.moviesdb.movies.list.di.GlobalNavigator
import com.example.moviesdb.navigation.GlobalNavigation
import dagger.Module
import dagger.Provides
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.Router
import javax.inject.Singleton

@Module
class NavigatorModule {

    private val cicerone: Cicerone<Router> = Cicerone.create()

    @Provides
    @Singleton
    fun provideMoviesListNavigator(@GlobalNavigation router: Router): MoviesListNavigator {
        return GlobalNavigator(router)
    }

    @Provides
    @Singleton
    fun provideNavigatorHolder() : NavigatorHolder {
        return cicerone.navigatorHolder
    }

    @Provides
    @Singleton
    @GlobalNavigation
    fun provideRouter(): Router {
        return cicerone.router
    }

    @Provides
    @Singleton
    fun provideCicerone() : Cicerone<Router> {
        return cicerone
    }
}