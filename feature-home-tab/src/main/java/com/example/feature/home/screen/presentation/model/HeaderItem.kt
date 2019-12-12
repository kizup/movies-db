package com.example.feature.home.screen.presentation.model

import com.example.feature.home.screen.R
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item
import kotlinx.android.synthetic.main.item_category_header.*

class HeaderItem(
    private val title: String,
    private val openAllItemClickListener: () -> Unit
) : Item() {

    override fun getLayout(): Int = R.layout.item_category_header

    override fun bind(
        viewHolder: GroupieViewHolder,
        position: Int
    ) {
        viewHolder.tvCategoryHeader.text = title
        viewHolder.tvAll.setOnClickListener { openAllItemClickListener() }
    }
}