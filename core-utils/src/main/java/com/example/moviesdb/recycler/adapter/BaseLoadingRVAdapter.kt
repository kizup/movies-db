package com.example.moviesdb.recycler.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.moviesdb.utils.R

abstract class BaseLoadingRVAdapter<Item, VH: RecyclerView.ViewHolder> : BaseRVAdapter<Item, VH>() {

    companion object {
        private const val ITEM_VIEW_TYPE = 0
        private const val LOADING_VIEW_TYPE = 1
    }

    open var isAllDataLoaded: Boolean = false

    abstract fun onCreateItemViewHolder(parent: ViewGroup, viewType: Int): VH

    override fun getItemCount(): Int {
        return if (isAllDataLoaded) {
            super.getItemCount()
        } else {
            super.getItemCount() + 1
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (isAllDataLoaded) {
            ITEM_VIEW_TYPE
        } else {
            if (position == itemCount - 1) {
                LOADING_VIEW_TYPE
            } else {
                ITEM_VIEW_TYPE
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        if (viewType == LOADING_VIEW_TYPE) {
            val view = inflate(parent, R.layout.loading_view_type)
            return LoadingViewHolder(view) as VH
        }
        return onCreateItemViewHolder(parent, viewType)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        if (getItemViewType(position) == LOADING_VIEW_TYPE) {
            return
        }
        onBindViewHolder(items[holder.adapterPosition], holder)
    }

}

class LoadingViewHolder(view: View) : RecyclerView.ViewHolder(view)