package com.example.moviesdb

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.moviesdb.movies.list.di.DaggerAppComponent
import com.example.moviesdb.network.api.TheMovieDBClientApi
import com.example.moviesdb.utils.ComponentDependenciesProvider
import com.example.moviesdb.utils.HasComponentDependencies
import javax.inject.Inject

class MainActivity : AppCompatActivity(), HasComponentDependencies {

    @Inject
    override lateinit var dependencies: ComponentDependenciesProvider

    override fun onCreate(savedInstanceState: Bundle?) {
        performInject()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    private fun performInject() {
        DaggerAppComponent.builder()
            .build()
            .inject(this)
    }

}
