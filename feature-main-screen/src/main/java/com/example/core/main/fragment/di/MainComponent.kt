package com.example.core.main.fragment.di

import com.example.core.main.fragment.api.MainDependencies
import com.example.core.main.fragment.presentation.view.MainFragment
import com.example.feature.home.screen.presentation.view.HomeFragment
import dagger.Component

@Component(
    dependencies = [ MainDependencies::class ]
)
interface MainComponent {

    fun inject(fragment: MainFragment)
}

//@Component(
//    dependencies = [ MoviesListDependencies::class ]
//)
//interface MoviesListComponent {
//    fun inject(fragment: MoviesListFragment)
//}