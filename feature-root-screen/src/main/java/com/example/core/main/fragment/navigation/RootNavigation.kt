package com.example.core.main.fragment.navigation

import androidx.navigation.NavController
import com.example.core.main.fragment.R
import com.example.feature.home.screen.navigation.IHomeNavigation
import javax.inject.Singleton

@Singleton
class RootNavigation : IHomeNavigation {

    var navController: NavController? = null

    override fun toMoviesList() {
        navController?.navigate(R.id.action_homeFragment_to_moviesListFragment)
    }
}