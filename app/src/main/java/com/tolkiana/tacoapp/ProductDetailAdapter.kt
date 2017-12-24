package com.tolkiana.tacoapp

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

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
        val layoutInflater = LayoutInflater.from(parent?.context)
        val rowView = layoutInflater.inflate(R.layout.list_row_product_details, parent,false)

        return when(viewType) {
            TYPE_INGREDIENTS -> IngredientsHolder(rowView)
            else -> PreparationHolder(rowView)
        }
    }

    class IngredientsHolder(private val parent: View?) : RecyclerView.ViewHolder(parent), BindableViewHolder {
        private val productDetailTextView: TextView = parent?.findViewById(R.id.productDetailTextView) as TextView

        override fun bind(product: Product) {
            var ingredients = product.ingredients.joinToString(separator = "\n\n")
            productDetailTextView.text = ingredients
        }

    }

    class PreparationHolder(private val parent: View?) : RecyclerView.ViewHolder(parent), BindableViewHolder {
        private val productDetailTextView: TextView = parent?.findViewById(R.id.productDetailTextView) as TextView

        override fun bind(product: Product) {
            var preparation = product.preparation.joinToString(separator = "\n\n")
            productDetailTextView.text = preparation
        }
    }

    interface BindableViewHolder {
        fun bind(product: Product)
    }
}