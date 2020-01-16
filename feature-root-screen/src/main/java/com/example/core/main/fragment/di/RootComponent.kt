package com.example.core.main.fragment.di

import com.example.core.main.fragment.api.RootDependencies
import com.example.core.main.fragment.presentation.view.RootFragment
import dagger.Component

@Component(
    dependencies = [RootDependencies::class]
)
interface RootComponent {

    fun inject(fragment: RootFragment)
}
