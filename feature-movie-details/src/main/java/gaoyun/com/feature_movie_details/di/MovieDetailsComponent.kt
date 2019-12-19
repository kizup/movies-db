package gaoyun.com.feature_movie_details.di

import com.example.moviesdb.root.tab.di.modules.NavigatorModule
import dagger.Component
import gaoyun.com.feature_movie_details.api.MovieDetailsDependencies
import gaoyun.com.feature_movie_details.presentation.view.MovieDetailsFragment

@Component(
    dependencies = [MovieDetailsDependencies::class],
    modules = [NavigatorModule::class]
)
interface MovieDetailsComponent {

    fun inject(fragment: MovieDetailsFragment)

}