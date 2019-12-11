package com.example.feature.home.screen.utils

import com.xwray.groupie.Group
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder

operator fun GroupAdapter<GroupieViewHolder>.plusAssign(item: Group) = this.add(item)
operator fun GroupAdapter<GroupieViewHolder>.plusAssign(items: List<Group>) = this.addAll(items)