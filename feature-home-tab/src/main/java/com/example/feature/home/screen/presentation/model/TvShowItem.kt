package com.example.feature.home.screen.presentation.model

import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.example.feature.home.screen.R
import com.example.moviesdb.network.model.TvShow
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item
import kotlinx.android.synthetic.main.item_movie.*

class TvShowItem(
    private val tvShow: TvShow
) : Item() {

    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        tvShow.posterPath?.let {
            val url = "https://image.tmdb.org/t/p/w400$it"
            Glide.with(viewHolder.ivCover)
                .load(url)
                .transform(CenterCrop())
                .transform(RoundedCorners(40))
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(viewHolder.ivCover)
        }
    }

    override fun getLayout(): Int = R.layout.item_movie

}