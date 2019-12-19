package gaoyun.com.feature_movie_details.api

import com.example.moviesdb.network.api.TheMovieDBClientApi
import com.example.moviesdb.utils.ComponentDependencies

interface MovieDetailsDependencies : ComponentDependencies {

    fun tmdbClient(): TheMovieDBClientApi

}