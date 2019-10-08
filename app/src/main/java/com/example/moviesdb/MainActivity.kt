package com.example.moviesdb

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.moviesdb.di.DaggerAppComponent
import com.example.moviesdb.network.api.TheMovieDBClientApi
import com.example.moviesdb.network.model.RETROFIT_IMPL
import com.example.moviesdb.network.model.TMDBLIB_IMPL
import com.example.moviesdb.utils.ComponentDependenciesProvider
import com.example.moviesdb.utils.HasComponentDependencies
import javax.inject.Inject
import javax.inject.Named

class MainActivity : AppCompatActivity(), HasComponentDependencies {

    @Inject
    override lateinit var dependencies: ComponentDependenciesProvider

    @Inject
    lateinit var tmdbClient: TheMovieDBClientApi

    override fun onCreate(savedInstanceState: Bundle?) {
        performInject()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        println(tmdbClient.javaClass.name)
    }

    private fun performInject() {
        DaggerAppComponent.builder()
            .build()
            .inject(this)
    }

}
