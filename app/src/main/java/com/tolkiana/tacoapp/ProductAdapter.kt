package com.tolkiana.tacoapp

import android.support.v7.widget.RecyclerView
import android.support.v7.widget.RecyclerView.Adapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

/**
 * Created by tolkiana on 7/11/17.
 */
class ProductAdapter(private val products: List<Product>): Adapter<ProductAdapter.ProductHolder>() {

    override fun getItemCount(): Int = products.size

    override fun onBindViewHolder(productHolder: ProductHolder?, position: Int) {
        val product = products[position]
        productHolder?.productNameTextView?.text = product.name
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ProductHolder {
        val layoutInflater = LayoutInflater.from(parent?.context)
        val productRowView = layoutInflater.inflate(R.layout.list_row_product, parent, false)
        return ProductHolder(productRowView)
    }

    class ProductHolder(view: View?) : RecyclerView.ViewHolder(view) {
        val productNameTextView: TextView = view?.findViewById(R.id.productNameTextView) as TextView
    }
}