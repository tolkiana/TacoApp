package com.tolkiana.tacoapp

import android.support.v7.widget.RecyclerView
import android.support.v7.widget.RecyclerView.Adapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.android.volley.toolbox.ImageLoader
import com.android.volley.toolbox.NetworkImageView

/**
 * Created by tolkiana on 7/11/17.
 */
class ProductAdapter(private val products: List<Product>, private val imageLoader: ImageLoader): Adapter<ProductAdapter.ProductHolder>() {

    override fun getItemCount(): Int = products.size

    override fun onBindViewHolder(productHolder: ProductHolder?, position: Int) {
        val product = products[position]
        productHolder?.productNameTextView?.text = product.name
        productHolder?.productImageView?.setImageUrl(product.imageURL, imageLoader)
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ProductHolder {
        val layoutInflater = LayoutInflater.from(parent?.context)
        val productRowView = layoutInflater.inflate(R.layout.list_row_product, parent, false)
        return ProductHolder(productRowView)
    }

    class ProductHolder(view: View?) : RecyclerView.ViewHolder(view) {
        val productNameTextView: TextView = view?.findViewById(R.id.productNameTextView) as TextView
        val productImageView: NetworkImageView = view?.findViewById(R.id.productImageView) as NetworkImageView
    }
}