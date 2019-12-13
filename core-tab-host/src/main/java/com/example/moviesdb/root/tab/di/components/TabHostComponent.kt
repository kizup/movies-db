package com.example.moviesdb.root.tab.di.components

import com.example.moviesdb.root.tab.api.TabHostDependencies
import com.example.moviesdb.root.tab.di.modules.NavigatorModule
import com.example.moviesdb.root.tab.presentation.view.HostFragment
import dagger.Component

@Component(
    modules = [
        NavigatorModule::class
    ]
)
interface TabHostComponent : TabHostDependencies {

    fun inject(fragment: HostFragment)

}