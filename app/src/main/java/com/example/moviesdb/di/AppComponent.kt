package com.example.moviesdb.di

import com.example.moviesdb.MainActivity
import com.example.moviesdb.utils.ComponentDependencies
import com.example.moviesdb.utils.ComponentDependenciesKey
import dagger.Binds
import dagger.Component
import dagger.Module
import dagger.multibindings.IntoMap
import javax.inject.Singleton

@Component(
    modules = [
        RetrofitNetworkModule::class,
//        TMDBLibNetworkModule::class,
        ComponentDependenciesModule::class
    ]
)
@Singleton
interface AppComponent : CoreNetworkApiDependencies {

    fun inject(activity: MainActivity)

}

@Module
private abstract class ComponentDependenciesModule private constructor() {

    @Binds
    @IntoMap
    @ComponentDependenciesKey(CoreNetworkApiDependencies::class)
    abstract fun provideCoreNetworkApiDependencies(appComponent: AppComponent): ComponentDependencies

}