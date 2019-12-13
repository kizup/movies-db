package com.example.moviesdb.root.tab.di.components

import com.example.moviesdb.root.tab.api.TabHostDependencies
import com.example.moviesdb.root.tab.di.modules.NavigatorModule
import com.example.moviesdb.root.tab.di.modules.TabComponentDependenciesModule
import com.example.moviesdb.root.tab.presentation.view.HostFragment
import dagger.Component

@Component(
    modules = [
        TabComponentDependenciesModule::class,
        NavigatorModule::class
    ]
)
interface TabHostComponent : TabHostDependencies {

    fun inject(fragment: HostFragment)

}