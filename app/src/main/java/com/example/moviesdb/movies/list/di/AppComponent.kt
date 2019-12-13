package com.example.moviesdb.movies.list.di

import com.example.core.main.fragment.api.RootDependencies
import com.example.feature.home.screen.api.HomeDependencies
import com.example.moviesdb.MainActivity
import com.example.moviesdb.db.di.CoreDatabaseApiDependencies
import com.example.moviesdb.movies.list.api.MoviesListDependencies
import com.example.moviesdb.movies.list.api.MoviesListNavigator
import com.example.moviesdb.movies.list.di.modules.NavigatorModule
import com.example.moviesdb.navigation.GlobalNavigation
import com.example.moviesdb.utils.ComponentDependencies
import com.example.moviesdb.utils.ComponentDependenciesKey
import dagger.Binds
import dagger.Component
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.Router
import javax.inject.Singleton

@Component(
    modules = [
        RetrofitNetworkModule::class,
//        TMDBLibNetworkModule::class,
        ComponentDependenciesModule::class,
        NavigatorModule::class
    ]
)
@Singleton
interface AppComponent :
//    CoreDatabaseApiDependencies,
    MoviesListDependencies,
    RootDependencies,
    HomeDependencies {

    fun inject(activity: MainActivity)

}

@Module
private abstract class ComponentDependenciesModule private constructor() {

//    @Binds
//    @IntoMap
//    @ComponentDependenciesKey(CoreNetworkApiDependencies::class)
//    abstract fun provideCoreNetworkApiDependencies(appComponent: AppComponent): ComponentDependencies

    @Binds
    @IntoMap
    @ComponentDependenciesKey(CoreDatabaseApiDependencies::class)
    abstract fun provideCoreDatabaseApiDependencies(appComponent: AppComponent): ComponentDependencies

    @Binds
    @IntoMap
    @ComponentDependenciesKey(MoviesListDependencies::class)
    abstract fun provideMoviesListDependencies(appComponent: AppComponent): ComponentDependencies

    @Binds
    @IntoMap
    @ComponentDependenciesKey(RootDependencies::class)
    abstract fun provideRootDependencies(appComponent: AppComponent): ComponentDependencies

    @Binds
    @IntoMap
    @ComponentDependenciesKey(HomeDependencies::class)
    abstract fun provideHomeDependencies(appComponent: AppComponent): ComponentDependencies

}