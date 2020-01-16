package com.example.core.main.fragment.di

import com.example.core.main.fragment.api.RootDependencies
import com.example.core.main.fragment.presentation.view.RootFragment
import com.example.feature.home.screen.navigation.IHomeNavigation
import dagger.Component
import javax.inject.Singleton

@Component(
    dependencies = [RootDependencies::class]
//    modules = [RootNavigationModule::class]
)
@Singleton
interface RootComponent {

    fun inject(fragment: RootFragment)

//    fun homeNavigation(): IHomeNavigation
}
