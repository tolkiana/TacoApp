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
        private val ingredientsTextView: TextView = parent?.findViewById(R.id.ingredientsTextView) as TextView

        override fun bind(product: Product) {
            ingredientsTextView.text = product.ingredients.first()
        }

    }

    class PreparationHolder(private val parent: View?) : RecyclerView.ViewHolder(parent), BindableViewHolder {
        private val preparationTextView: TextView = parent?.findViewById(R.id.preparationTextView) as TextView

        override fun bind(product: Product) {
            preparationTextView.text = product.preparation.first()
        }
    }

    interface BindableViewHolder {
        fun bind(product: Product)
    }
}