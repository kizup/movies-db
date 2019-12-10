package com.example.feature.home.screen.presentation.model

import com.example.feature.home.screen.R
import com.example.moviesdb.network.model.Movie
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item

class MovieItem(
    private val movie: Movie
) : Item() {

    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
    }

    override fun getLayout(): Int = R.layout.item_movie
}