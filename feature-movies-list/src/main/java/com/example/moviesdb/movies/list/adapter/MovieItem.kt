package com.example.moviesdb.movies.list.adapter

import android.view.View
import android.widget.TextView
import com.example.moviesdb.movies.list.R
import com.example.moviesdb.network.model.Movie
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.items.AbstractItem

open class MovieItem(
    private val movie: Movie
) : AbstractItem<MovieItem.ViewHolder>() {

    override val layoutRes: Int
        get() = R.layout.movie_item

    override val type: Int
        get() = R.id.movie_list_item

    override fun getViewHolder(v: View): ViewHolder {
        return ViewHolder(v)
    }

    class ViewHolder(view: View) : FastAdapter.ViewHolder<MovieItem>(view) {

        private val tvTitle = view.findViewById<TextView>(R.id.tvMovieTitle)
        private val tvReleaseDate = view.findViewById<TextView>(R.id.tvMovieReleaseDate)

        override fun bindView(item: MovieItem, payloads: MutableList<Any>) {
            val movie = item.movie
            tvTitle.text = movie.title
            tvReleaseDate.text = movie.releaseDate?.toString()
        }

        override fun unbindView(item: MovieItem) {

        }
    }

}