package com.example.core.main.fragment.api

import com.example.core.main.fragment.navigation.RootNavigation
import com.example.moviesdb.utils.ComponentDependencies

interface RootDependencies : ComponentDependencies {

    fun rootNavigation(): RootNavigation

}