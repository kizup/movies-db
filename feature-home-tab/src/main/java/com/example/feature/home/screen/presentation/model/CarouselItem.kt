package com.example.feature.home.screen.presentation.model

import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.feature.home.screen.R
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item
import kotlinx.android.synthetic.main.item_carousel.*

class CarouselItem(
    private val movieItems: List<Item>,
    private val clickAction: (Item) -> Unit
) : Item() {

    private val moviesAdapter = GroupAdapter<GroupieViewHolder>()
    private var linearLayoutManager: LinearLayoutManager? = null

    override fun createViewHolder(itemView: View): GroupieViewHolder {
        linearLayoutManager = LinearLayoutManager(itemView.context, RecyclerView.HORIZONTAL, false)
        moviesAdapter.setHasStableIds(true)
        return super.createViewHolder(itemView).apply {
            rvCarousel.layoutManager = linearLayoutManager
            rvCarousel.setHasFixedSize(true)
            LinearSnapHelper().attachToRecyclerView(rvCarousel)
        }
    }

    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        moviesAdapter.setOnItemClickListener { item, _ ->  clickAction(item as Item) }
        viewHolder.rvCarousel.adapter = moviesAdapter
        moviesAdapter.clear()
        moviesAdapter.addAll(movieItems)
    }

    override fun unbind(viewHolder: GroupieViewHolder) {
        moviesAdapter.setOnItemClickListener(null)
        super.unbind(viewHolder)
    }

    override fun getLayout(): Int = R.layout.item_carousel

}