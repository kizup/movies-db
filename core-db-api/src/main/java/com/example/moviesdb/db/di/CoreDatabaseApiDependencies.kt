package com.example.moviesdb.db.di

import com.example.moviesdb.db.api.TmdbExampleDbApi
import com.example.moviesdb.utils.ComponentDependencies

interface CoreDatabaseApiDependencies : ComponentDependencies {

    fun tmdbDatabase(): TmdbExampleDbApi

}