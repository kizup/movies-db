package com.example.moviesdb.root.tab.di.components

import com.example.moviesdb.root.tab.di.scope.TabHostScope
import com.example.moviesdb.root.tab.presentation.view.HostFragment
import dagger.Component

@Component()
@TabHostScope
interface TabHostComponent {
    fun inject(fragment: HostFragment)
}