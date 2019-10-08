package com.example.moviesdb.recycler.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

abstract class BaseRVAdapter<Item, VH: RecyclerView.ViewHolder> : RecyclerView.Adapter<VH>() {

    companion object {
        const val NO_HOLDER_POSITION = RecyclerView.NO_POSITION
    }

    var itemClickListener: ((Item) -> Unit)? = null
    protected val items: ArrayList<Item> = ArrayList()

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: VH, position: Int) {
        val item = items[holder.adapterPosition]
        onBindViewHolder(item, holder)
    }

    abstract fun onBindViewHolder(item: Item, holder: VH)

    protected fun inflate(parent: ViewGroup, layoutId: Int): View {
        val inflater = LayoutInflater.from(parent.context)
        return inflater.inflate(layoutId, parent, false)
    }

    fun addItems(items: List<Item>) {
        val startPosition = itemCount
        this.items.addAll(items)
        notifyItemRangeInserted(startPosition, items.size)
    }

}