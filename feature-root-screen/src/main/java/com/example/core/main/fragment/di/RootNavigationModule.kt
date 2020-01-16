package com.example.core.main.fragment.di

import com.example.core.main.fragment.navigation.RootNavigation
import com.example.feature.home.screen.navigation.IHomeNavigation
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RootNavigationModule {

    init {
        println()
    }

    private val rootNavigation = RootNavigation()

    @Provides
    @Singleton
    fun provideHomeNavigation(): IHomeNavigation {
        return rootNavigation
    }

    @Provides
    @Singleton
    fun provideRootNavigation(): RootNavigation {
        return rootNavigation
    }

}