package com.example.moviesdb.root.tab.di.components

import com.example.moviesdb.root.tab.di.modules.NavigatorModule
import com.example.moviesdb.root.tab.di.scope.TabHostScope
import com.example.moviesdb.root.tab.navigation.ILocalNavigator
import com.example.moviesdb.root.tab.presentation.view.HostFragment
import dagger.Component
import dagger.Module

@Component(
    modules = [ NavigatorModule::class, ComponentsModule::class ]
)
@TabHostScope
interface TabHostComponent {

    fun inject(fragment: HostFragment)

    fun localNavigator(): ILocalNavigator

}

@Module
abstract class ComponentsModule {}