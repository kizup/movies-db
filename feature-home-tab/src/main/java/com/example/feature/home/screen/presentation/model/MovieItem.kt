package com.example.feature.home.screen.presentation.model

import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.example.feature.home.screen.R
import com.example.moviesdb.network.model.Movie
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item
import kotlinx.android.synthetic.main.item_movie.*

class MovieItem(
    private val movie: Movie
) : Item() {

    private var requestManager: RequestManager? = null

    override fun getId(): Long {
        return movie.id
    }

    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        movie.posterPath?.let {
            val url = "https://image.tmdb.org/t/p/w400$it"
            requestManager = Glide.with(viewHolder.ivCover).apply {
                load(url)
                    .transform(CenterCrop())
                    .transform(RoundedCorners(40))
                    .transition(DrawableTransitionOptions.withCrossFade())
                    .into(viewHolder.ivCover)
            }
        }
    }

    override fun unbind(viewHolder: GroupieViewHolder) {
        requestManager?.clear(viewHolder.ivCover)
        super.unbind(viewHolder)
    }

    override fun getLayout(): Int = R.layout.item_movie
}