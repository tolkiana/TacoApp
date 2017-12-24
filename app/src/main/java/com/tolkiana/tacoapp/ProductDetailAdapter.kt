package com.tolkiana.tacoapp

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Created by tolkiana on 12/23/17.
 */
class ProductDetailAdapter(private val product: Product) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        const val TYPE_INGREDIENTS = 0
        const val TYPE_PREPARATION = 1
    }

    override fun getItemViewType(position: Int): Int {
        return when (position) {
            0 -> TYPE_INGREDIENTS
            else -> TYPE_PREPARATION
        }
    }

    override fun getItemCount(): Int = 2

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
        (holder as BindableViewHolder).bind(product)
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder {
        return when(viewType) {
            TYPE_INGREDIENTS -> IngredientsHolder(createView(parent, R.layout.list_row_product_ingredients))
            else -> PreparationHolder(createView(parent, R.layout.list_row_product_preparation))
        }
    }

    private fun createView(parent: ViewGroup?, identifier: Int) : View {
        val layoutInflater = LayoutInflater.from(parent?.context)
        return layoutInflater.inflate(identifier, parent,false)
    }

    class IngredientsHolder(private val parent: View?) : RecyclerView.ViewHolder(parent), BindableViewHolder {
        override fun bind(product: Product) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

    }

    class PreparationHolder(private val parent: View?) : RecyclerView.ViewHolder(parent), BindableViewHolder {
        override fun bind(product: Product) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

    }

    interface BindableViewHolder {
        fun bind(product: Product)
    }
}