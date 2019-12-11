package com.example.feature.home.screen.presentation.model

import com.example.feature.home.screen.R
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item

object SpaceItem : Item() {
    override fun bind(viewHolder: GroupieViewHolder, position: Int) {}

    override fun getLayout(): Int = R.layout.item_space
}