package com.example.moviesdb.movies.list.di

import com.example.moviesdb.movies.list.api.MoviesListDependencies
import com.example.moviesdb.movies.list.presentation.view.MoviesListFragment
import dagger.Component

@Component(
    dependencies = [ MoviesListDependencies::class ]
)
interface MoviesListComponent {
    fun inject(fragment: MoviesListFragment)
}