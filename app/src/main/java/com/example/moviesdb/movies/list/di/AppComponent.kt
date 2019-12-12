package com.example.moviesdb.movies.list.di

import com.example.core.main.fragment.api.MainDependencies
import com.example.feature.home.screen.api.HomeDependencies
import com.example.moviesdb.MainActivity
import com.example.moviesdb.db.di.CoreDatabaseApiDependencies
import com.example.moviesdb.movies.list.api.MoviesListDependencies
import com.example.moviesdb.movies.list.api.MoviesListNavigator
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
    MainDependencies,
    HomeDependencies {

    fun inject(activity: MainActivity)

}

@Module
class NavigatorModule {

    private val cicerone: Cicerone<Router> = Cicerone.create()

    @Provides
    @Singleton
    fun provideMoviesListNavigator(router: Router): MoviesListNavigator {
        return GlobalNavigator(router)
    }

    @Provides
    @Singleton
    fun provideNavigatorHolder() : NavigatorHolder {
        return cicerone.navigatorHolder
    }

    @Provides
    @Singleton
    fun provideRouter(): Router {
        return cicerone.router
    }

    @Provides
    @Singleton
    fun provideCicerone() : Cicerone<Router> {
        return cicerone
    }
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
    @ComponentDependenciesKey(MainDependencies::class)
    abstract fun provideMainDependencies(appComponent: AppComponent): ComponentDependencies

    @Binds
    @IntoMap
    @ComponentDependenciesKey(HomeDependencies::class)
    abstract fun provideHomeDependencies(appComponent: AppComponent): ComponentDependencies

}