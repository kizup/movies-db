package com.example.feature.home.screen.adapter

import android.view.View
import com.example.feature.home.screen.R
import com.example.moviesdb.network.model.Movie
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.items.AbstractItem

class NowPlayingMovieItem(
    private val movie: Movie
) : AbstractItem<NowPlayingMovieItem.ViewHolder>() {

    override fun getViewHolder(v: View): ViewHolder {
        return ViewHolder(v)
    }

    override val layoutRes: Int
        get() = R.layout.item_movie

    override val type: Int
        get() = 0

    class ViewHolder(view: View) : FastAdapter.ViewHolder<NowPlayingMovieItem>(view) {


        override fun bindView(item: NowPlayingMovieItem, payloads: MutableList<Any>) {

        }

        override fun unbindView(item: NowPlayingMovieItem) {
        }

    }
}
