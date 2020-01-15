package com.example.feature.home.screen.di

import com.example.feature.home.screen.api.HomeDependencies
import com.example.feature.home.screen.presentation.view.HomeFragment
import dagger.Component

@Component(dependencies = [ HomeDependencies::class] )
interface HomeComponent {
    fun inject(fragment: HomeFragment)
}