package com.example.feature.home.screen.presentation.model

import com.example.feature.home.screen.R
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item
import kotlinx.android.synthetic.main.item_carousel.*

class CarouselItem(
    private val movieItems: List<MovieItem>
) : Item() {

    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        viewHolder.rvCarousel.apply {
            // TODO setup recycler view
        }
    }

    override fun getLayout(): Int = R.layout.item_carousel

}