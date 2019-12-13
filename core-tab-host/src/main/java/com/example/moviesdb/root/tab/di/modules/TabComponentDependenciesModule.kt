package com.example.moviesdb.root.tab.di.modules

import com.example.moviesdb.root.tab.api.TabHostDependencies
import com.example.moviesdb.root.tab.di.components.TabHostComponent
import com.example.moviesdb.utils.ComponentDependencies
import com.example.moviesdb.utils.ComponentDependenciesKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class TabComponentDependenciesModule private constructor() {

    @Binds
    @IntoMap
    @ComponentDependenciesKey(TabHostDependencies::class)
    abstract fun provideTabHostDependencies(tabHostComponent: TabHostComponent) : ComponentDependencies

}