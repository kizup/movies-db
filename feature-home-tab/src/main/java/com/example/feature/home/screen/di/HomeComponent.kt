package com.example.feature.home.screen.di

import com.example.feature.home.screen.api.HomeDependencies
import com.example.feature.home.screen.presentation.view.HomeFragment
import com.example.moviesdb.root.tab.di.modules.NavigatorModule
import dagger.Component

@Component(
    dependencies = [HomeDependencies::class],
    modules = [NavigatorModule::class]
)
interface HomeComponent {

    fun inject(fragment: HomeFragment)

}