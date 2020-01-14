package com.example.moviesdb.root.tab.di.components

import com.example.moviesdb.root.tab.api.TabHostDependencies
import com.example.moviesdb.root.tab.di.modules.NavigatorModule
import com.example.moviesdb.root.tab.di.scope.TabHostScope
import com.example.moviesdb.root.tab.navigation.ILocalNavigator
import com.example.moviesdb.root.tab.presentation.view.HostFragment
import dagger.Component
import javax.inject.Singleton

@Component(
    modules = [ NavigatorModule::class ],
    dependencies = [ TabHostDependencies::class ]
)
@Singleton
interface TabHostComponent {

    fun inject(fragment: HostFragment)

    fun localNavigator(): ILocalNavigator

}