package com.tolkiana.tacoapp

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Created by tolkiana on 1/28/18.
 */
class HomeAdpater: RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var onItemClickListener: HomeAdpater.OnItemClickListener? = null

    override fun getItemCount(): Int = 3

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
        (holder as ItemHolder).bind(onItemClickListener)
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent?.context)
        val itemRowView = layoutInflater.inflate(R.layout.list_row_menu_item, parent, false)
        return ItemHolder(itemRowView)
    }

    class ItemHolder(private val parent: View?) : RecyclerView.ViewHolder(parent) {
        fun bind(onItemClickListener: OnItemClickListener?) {
            parent?.setOnClickListener {
                onItemClickListener?.onItemClick()
            }
        }
    }

    interface OnItemClickListener {
        fun onItemClick()
    }
}