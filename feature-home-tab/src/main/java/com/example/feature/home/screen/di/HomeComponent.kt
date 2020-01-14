package com.example.feature.home.screen.di

import com.example.feature.home.screen.api.HomeDependencies
import com.example.feature.home.screen.presentation.view.HomeFragment
import com.example.feature.home.screen.presentation.view.TargetFragment
import dagger.Component

@Component(
    dependencies = [ HomeDependencies::class ]
)
interface HomeComponent {

    fun inject(fragment: HomeFragment)
    fun inject(fragment: TargetFragment)

}